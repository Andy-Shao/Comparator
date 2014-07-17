package comparator.impl;

import java.util.Comparator;

public class DefaultComparator<T> implements Comparator<T>{

	@Override
    public int compare(T one, T another) {
	    return one.hashCode() - another.hashCode();
    }

}
