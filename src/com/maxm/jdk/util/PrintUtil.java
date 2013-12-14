package com.maxm.jdk.util;

import java.io.PrintStream;

public class PrintUtil {
	private static PrintStream out = System.out;

	public static void println(Object obj) {
		out.println(obj);
	}

	public static void println() {
		out.println();
	}
}
