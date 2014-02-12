package com.maxm.jdk.util;

import java.nio.Buffer;

public class BufferUtil {

	public static void showBufferState(Buffer buffer) {
		String[] meta = { "position:" + buffer.position(),
				"limit:" + buffer.limit(), "capacity:" + buffer.capacity() };
		PrintUtil.showAsOneLine(meta);
	}

}
