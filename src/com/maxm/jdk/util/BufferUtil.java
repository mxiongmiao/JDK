package com.maxm.jdk.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferUtil {

	public static void showBufferState(Buffer buffer) {
		String[] meta = { "position:" + buffer.position(),
				"limit:" + buffer.limit(), "capacity:" + buffer.capacity() };
		PrintUtil.showAsOneLine(meta);
	}

	// 查看原来缓冲区内容
	public static void viewBuffer(ByteBuffer buffer) {
		buffer.position(0);
		buffer.limit(buffer.capacity());
		StringBuffer ret = new StringBuffer(buffer.capacity());
		while (buffer.remaining() > 0) {
			ret.append(buffer.get()).append(",");
		}
		ret.setLength(ret.length() - 1);
		PrintUtil.println(ret);
	}

}
