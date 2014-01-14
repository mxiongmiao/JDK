package com.maxm.jdk.generic;

import java.util.Collection;
import java.util.Iterator;

public interface MyList<E> {
	
	Iterator<E> iterator();
	
	<T> T[] toArr(T[] a);
	
	boolean addAll(Collection<? extends E> c);
	
	boolean add(E e);
	
	boolean removeAll(Collection<?> c);
}
