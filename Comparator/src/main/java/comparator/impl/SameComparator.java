package comparator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import comparator.ComformityResult;
import comparator.Item;

public class SameComparator<ITEM extends Item<?>> extends HashLineMsgComparator<ComformityResult<ITEM>, ITEM> {
	
	public SameComparator() {
		setTakeSame(true);
	}

	@Override
	protected ComformityResult<ITEM> buildComparatorResult(ConcurrentMap<ITEM, Object> channelA, ConcurrentMap<ITEM, Object> channelB) {
		final List<ITEM> sameLine = new ArrayList<ITEM>();
		drain(channelA, channelB, sameLine); 
		drain(channelB, channelA, sameLine);
		
		return new ComformityResult<ITEM>() {

			@Override
			public List<ITEM> sames() {
				return sameLine;
			}
			
		};
	}

	static <K,V> void drain(ConcurrentMap<K, V> channelA, ConcurrentMap<K, V> channelB, final List<K> sameLine) {
		for(Map.Entry<K, V> entry : channelA.entrySet()) {
			K key = entry.getKey();
			if(channelB.containsKey(key)){
				sameLine.add(key);
				channelA.remove(key);
				channelB.remove(key);
			}
		}
	}

}
