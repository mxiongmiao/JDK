package com.maxm.jdk.io.nio;

import java.nio.IntBuffer;

import com.maxm.jdk.util.PrintUtil;

public class IntBufferTest {

	public static void main(String[] args) {
		IntBuffer intBuff = IntBuffer.allocate(4);
		viewBuffer(intBuff);

		intBuff.put(1);
		// 缓冲区position不能超过limit
		// intBuff.flip();
		viewBuffer(intBuff);
		intBuff.put(2);
		intBuff.put(3);
		intBuff.put(4);
		viewBuffer(intBuff);

		intBuff.clear();
		viewBuffer(intBuff);
	}

	private static void viewBuffer(IntBuffer intBuff) {
		Object[] datas = { "position:" + intBuff.position(),
				"limit:" + intBuff.limit(), "capacity:" + intBuff.capacity() };
		PrintUtil.showAsOneLine(",", datas);
	}

}
