package com.maxm.jdk.collection;

import java.util.HashMap;
import java.util.Hashtable;

import com.maxm.jdk.util.PrintUtil;

public class TestHashMap {
	public static void main(String[] args) {
		testNullKey();
	}

	private static void testNullKey() {
		HashMap<String, Object> map = new HashMap<>();
		map.put(null, new Object());
		Object Null = map.get(null);
		PrintUtil.println(Null);

		boolean containsKey = map.containsKey(null);
		PrintUtil.println(containsKey);

		Hashtable<String, Object> ht = new Hashtable<>();
		ht.put("null", "");
		boolean containsKey2 = ht.containsKey("null");
		PrintUtil.println(containsKey2);
	}
}
