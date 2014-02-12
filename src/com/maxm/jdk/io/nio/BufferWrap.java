package com.maxm.jdk.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

import com.maxm.jdk.util.BufferUtil;
import com.maxm.jdk.util.PrintUtil;

public class BufferWrap {

	public static ByteBuffer wrap(byte[] input) {
		return ByteBuffer.wrap(input);
	}

	public static CharBuffer wrap(char[] input) {
		return CharBuffer.wrap(input);
	}

	public static IntBuffer wrap(int[] input) {
		return IntBuffer.wrap(input);
	}

	public static FloatBuffer wrap(float[] input) {
		return FloatBuffer.wrap(input);
	}

	public static LongBuffer wrap(long[] input) {
		return LongBuffer.wrap(input);
	}

	public static DoubleBuffer wrap(double[] input) {
		return DoubleBuffer.wrap(input);
	}

	public static void main(String[] args) {
		byte[] bytes = new byte[10];
		ByteBuffer wrap = wrap(bytes);
		wrap.put((byte) 0);
		wrap.put((byte) 1);
		wrap.put((byte) 2);
		wrap.put((byte) 3);
		PrintUtil.println(wrap.get(0));
		PrintUtil.println(wrap.get(2));

		BufferUtil.showBufferState(wrap);

		float[] finput = { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f };
		FloatBuffer fwrap = wrap(finput);
		BufferUtil.showBufferState(fwrap);

		PrintUtil.println(fwrap.get());
		fwrap.flip();

		BufferUtil.showBufferState(fwrap);
	}

}
