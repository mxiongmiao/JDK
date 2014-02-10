package com.maxm.jdk.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.maxm.jdk.util.PrintUtil;

// FIXME finish other funcs
public class MyArrayList<E> implements MyList<E> {

	private transient Object[] elemntData;
	private int size;

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public <T> T[] toArr(T[] dest) {
		System.arraycopy(elemntData, 0, dest, 0, size);
		return dest;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean add(E e) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	public static void main(String[] args) {
		int[] original = { 11, 22, 33 };
		int[] copyOf = Arrays.copyOf(original, 2);
		// expect 2
		PrintUtil.println(copyOf.length);
		// expect 11
		PrintUtil.println(copyOf[0]);
		// expect 22
		PrintUtil.println(copyOf[1]);
		// throw ArrayIndexOutOfBoundsException
		PrintUtil.println(copyOf[2]);
	}
}
