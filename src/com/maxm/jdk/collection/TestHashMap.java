package com.maxm.jdk.collection;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMap {
	public static void main(String[] args) {
		testPut();
	}

	private static void testPut() {
		HashMap<String, Object> map = new HashMap<>();
		map.put(null, new Object());
		Object Null = map.get(null);
		System.out.println(Null);

		boolean containsKey = map.containsKey(null);
		System.out.println(containsKey);

		Hashtable<String, Object> ht = new Hashtable<>();
		ht.put("null", "");
		ht.containsKey("null");
	}
}
