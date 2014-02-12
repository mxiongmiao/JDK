package com.maxm.jdk.io.nio;

import java.nio.ByteBuffer;

import com.maxm.jdk.util.BufferUtil;
import com.maxm.jdk.util.PrintUtil;

public class BufferTest {

	public static void main(String[] args) {
		// 构建并填充一缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		BufferUtil.showBufferState(buffer);

		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put((byte) i);
		}
		PrintUtil.println("原缓冲区:");
		BufferUtil.viewBuffer(buffer);

		// 创建子缓冲区(分片)
		PrintUtil.println("创建子缓冲区 positon(1,3):");
		buffer.position(1);
		buffer.limit(3);
		ByteBuffer slice = buffer.slice();
		PrintUtil.println("子缓冲区:");
		BufferUtil.viewBuffer(slice);
		// 转换为只读缓冲区
		// ByteBuffer oldBuffer = buffer.asReadOnlyBuffer();
		// BufferUtil.viewBuffer(oldBuffer);
		// 修改子缓冲区内容
		PrintUtil.println("子缓冲区每个元素*2");
		for (int i = 0; i < slice.capacity(); i++) {
			byte b = slice.get(i);
			b *= 2;
			slice.put(i, b);
		}
		PrintUtil.println("子缓冲区：");
		BufferUtil.viewBuffer(slice);
		PrintUtil.println("原缓冲区：");
		BufferUtil.viewBuffer(buffer);
		PrintUtil.println("显然子缓冲区元素的修改映射到了原缓冲区,可见它们共享底层数组");
	}

}
