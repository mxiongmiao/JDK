package com.maxm.jdk.operator;

import com.maxm.jdk.util.PrintUtil;

public class OperatorTest {
	public static void main(String[] args) {
		// 位运算符,直接操作位
		// 按位或
		PrintUtil.println(1 | 3);
		// 按位亦或
		PrintUtil.println(1 ^ 3);
		// 按位与
		PrintUtil.println(1 & 3);
		// 非
		byte i = 127;
		byte j = ++i;
		PrintUtil.println(j);
		PrintUtil.println(~5);
		PrintUtil.println(~127);
		byte r = (byte)((byte)126+(byte)3);
		PrintUtil.println(r);
	}
}
