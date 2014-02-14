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
	}
}
