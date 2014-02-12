package com.maxm.jdk.util;

import java.io.PrintStream;

public class PrintUtil {
	private static PrintStream out = System.out;

	public static void println(final Object obj) {
		out.println(obj);
	}

	public static void println() {
		out.println();
	}

	public static void showAsOneLine(Object[] datas) {
		showAsOneLine(" ", datas);
	}

	public static void showAsOneLine(String split, Object[] datas) {
		StringBuffer buffer = new StringBuffer();
		for (Object data : datas) {
			buffer.append(data).append(split);
		}
		if (buffer.length() > 0) {
			buffer.setLength(buffer.length() - 1);
		}
		println(buffer);
	}

	public static void main(String[] args) {
		String[] input = { "i", "love", "u" };
		showAsOneLine(input);
		showAsOneLine("-", input);
	}

}
