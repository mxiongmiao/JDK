package com.maxm.jdk.collection;

import java.util.HashMap;
import java.util.Hashtable;

import com.maxm.jdk.util.PrintUtil;

public class TestHashMap {
	public static void main(final String[] args) {
		testNullKey();
	}

	private static void testNullKey() {
		final HashMap<String, Object> map = new HashMap<>();
		map.put(null, new Object());
		final Object Null = map.get(null);
		PrintUtil.println(Null);

		final boolean containsKey = map.containsKey(null);
		PrintUtil.println(containsKey);

		final Hashtable<String, Object> ht = new Hashtable<>();
		ht.put("null", "");
		final boolean containsKey2 = ht.containsKey("null");
		PrintUtil.println(containsKey2);
	}
}
