package comparator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import comparator.DifferentResult;
import comparator.Item;
import comparator.DifferentResult.LineCouple;

public class DifferentComparator<ITEM extends Item<?>> extends HashLineMsgComparator<DifferentResult<ITEM>, ITEM> {

	private volatile Comparator<ITEM> lineMsgComparator;

	public DifferentComparator() {
		setTakeSame(false);
	}
	
	@Override
	protected DifferentResult<ITEM> buildComparatorResult(ConcurrentMap<ITEM, Object> channelA, ConcurrentMap<ITEM, Object> channelB) {
		// the information which need return.
		final List<ITEM> onlyFileAHas = new ArrayList<ITEM>();
		final List<ITEM> onlyFileBHas = new ArrayList<ITEM>();
		final List<LineCouple<ITEM>> differences = new ArrayList<DifferentResult.LineCouple<ITEM>>();

		List<ITEM> beSort = null;
		ConcurrentMap<ITEM, Object> neverSort = null;
		boolean isChannelA = false;
		if (channelA.size() <= channelB.size()) {
			isChannelA = true;
			beSort = new ArrayList<ITEM>(channelA.keySet());
			neverSort = channelB;
			Collections.sort(beSort, lineMsgComparator);
		} else if (channelB.size() < channelA.size()) {
			isChannelA = false;
			beSort = new ArrayList<ITEM>(channelB.keySet());
			neverSort = channelA;
			Collections.sort(beSort, lineMsgComparator);
		}
		for (ConcurrentMap.Entry<ITEM, Object> entry : neverSort.entrySet()) {
			ITEM lineMessage = entry.getKey();
			int index = Collections.binarySearch(beSort, lineMessage, lineMsgComparator);
			if (index >= 0) {
				ITEM temp = beSort.remove(index);
				if (isChannelA) differences.add(new DifferentResult.DefaultLineCouple<ITEM>(temp, lineMessage));
				else differences.add(new DifferentResult.DefaultLineCouple<ITEM>(lineMessage, temp));
			} else {
				if (isChannelA) onlyFileBHas.add(lineMessage);
				else onlyFileAHas.add(lineMessage);
			}
		}
		if (isChannelA) onlyFileAHas.addAll(beSort);
		else onlyFileBHas.addAll(beSort);

		return new DifferentResult<ITEM>() {

			@Override
			public List<ITEM> onlyFileAHas() {
				return onlyFileAHas;
			}

			@Override
			public List<ITEM> onlyFileBHas() {
				return onlyFileBHas;
			}

			@Override
			public List<comparator.DifferentResult.LineCouple<ITEM>> differences() {
				return differences;
			}
		};
	}

	public void setLineMsgComparator(Comparator<ITEM> lineMsgComparator) {
		this.lineMsgComparator = lineMsgComparator;
	}
}
