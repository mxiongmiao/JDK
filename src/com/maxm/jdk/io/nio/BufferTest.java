package com.maxm.jdk.io.nio;

import java.nio.ByteBuffer;

import com.maxm.jdk.util.PrintUtil;

public class BufferTest {

	public static void main(String[] args) {
		// 构建并填充一缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		String[] bufferState = { "position:" + buffer.position(),
				"limit:" + buffer.limit(), "capacity:" + buffer.capacity() };
		PrintUtil.showAsOneLine(bufferState);
		
		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put((byte) i);
		}
		// 创建子缓冲区(分片)
		buffer.position(1);
		buffer.limit(3);
		ByteBuffer slice = buffer.slice();
		ByteBuffer oldBuffer = buffer.asReadOnlyBuffer();
		viewBuffer(oldBuffer);
		PrintUtil.println(";;;");
		for (int i = 0; i < slice.capacity(); i++) {
			byte b = slice.get(i);
			b *= 2;
			slice.put(i, b);
		}
		viewBuffer(buffer);
	}

	private static void viewBuffer(ByteBuffer buffer) {
		// 查看原来缓冲区内容
		buffer.position(0);
		buffer.limit(buffer.capacity());
		while (buffer.remaining() > 0) {
			PrintUtil.println(buffer.get());
		}
	}

}
