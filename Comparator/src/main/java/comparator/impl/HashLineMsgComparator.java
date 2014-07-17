package comparator.impl;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import comparator.ComparatorResult;
import comparator.Item;
import comparator.MessageComparator;

public abstract class HashLineMsgComparator<E extends ComparatorResult, ITEM extends Item<?>> implements
		MessageComparator<E, Iterator<ITEM>, Iterator<ITEM>> {
	protected static final int DEFAULT_TEMP_SIZE = 102400;
	private static final Integer DEFAULT_VALUE = 1;
	private volatile boolean takeSame = false;

	@Override
	public E compare(Iterator<ITEM> channelA, Iterator<ITEM> channelB) throws comparator.MessageComparator.CompareException {
		// the temporary of channels
		final ConcurrentMap<ITEM, Object> tempA = new ConcurrentHashMap<ITEM, Object>(DEFAULT_TEMP_SIZE);
		final ConcurrentMap<ITEM, Object> tempB = new ConcurrentHashMap<ITEM, Object>(DEFAULT_TEMP_SIZE);

		if(isTakeSame()){
			while(true){
				boolean canReadA = channelA.hasNext();
				boolean canReadB = channelB.hasNext();
				if(canReadA) tempA.put(channelA.next(), DEFAULT_VALUE);
				if(canReadB) tempB.put(channelB.next(), DEFAULT_VALUE);
				
				if (!canReadA && !canReadB) break;
			}
		} else {
			while (true) {
				boolean canReadA = channelA.hasNext();
				boolean canReadB = channelB.hasNext();
				if (canReadA) {
					ITEM next = channelA.next();
					if (!tempB.containsKey(next)) tempA.put(next, DEFAULT_VALUE);
					else tempB.remove(next);
				}
				if (canReadB) {
					ITEM next = channelB.next();
					if (!tempA.containsKey(next)) tempB.put(next, DEFAULT_VALUE);
					else tempA.remove(next);
				}
				
				if (!canReadA && !canReadB) break;
			}
			
			checking(tempA, tempB);
			checking(tempB, tempA);
		}

		return buildComparatorResult(tempA, tempB);
	}

	protected abstract E buildComparatorResult(ConcurrentMap<ITEM, Object> channelA, ConcurrentMap<ITEM, Object> channelB);

	static <K, V> void checking(ConcurrentMap<K, V> channelA, ConcurrentMap<K, V> channelB) {
		for (ConcurrentMap.Entry<K, V> entry : channelA.entrySet()) {
			K key = entry.getKey();
			if (channelB.containsKey(key)) {
				channelB.remove(key);
				channelA.remove(key);
			}
		}
	}

	public boolean isTakeSame() {
		return takeSame;
	}

	public void setTakeSame(boolean takeSame) {
		this.takeSame = takeSame;
	}
}
