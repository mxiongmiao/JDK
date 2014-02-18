package com.maxm.jdk.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class FileUtil {
	private static final String lineSeperator = System.lineSeparator();

	/**
	 * 以流的方式读文件内容
	 * 
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public static StringBuffer read(File f) throws IOException {
		StringBuffer data = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(f), "utf-8"));
		for (;;) {
			String readLine = br.readLine();
			if (readLine == null) {
				break;
			}
			data.append(readLine).append(lineSeperator);
		}
		close(br);
		return data;
	}

	@SuppressWarnings("resource")
	public static void copy(File from, File to) throws IOException {
		// bio直接从 流中读取，而nio会从流对应的通道中读取
		FileChannel fci = new FileInputStream(from).getChannel();
		FileChannel fco = new FileOutputStream(to).getChannel();

		// ByteBuffer buffer = ByteBuffer.allocate(1024);
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		for (;;) {
			// 从输入通道读取数据到缓冲区
			buffer.clear();
			int r = fci.read(buffer);
			if (r == -1) {
				break;
			}
			// 将缓冲区内容写入输出通道
			buffer.flip();
			fco.write(buffer);
		}

		close(fco);
		close(fci);
	}

	// 抛出异常交给调用者去处理
	private static void close(Closeable br) throws IOException {
		if (br != null) {
			br.close();
			br = null;
		}
	}

	public static void main(String[] args) throws IOException {
		// change to yours
		File f = new File("E:/GitHub/JDK/data/queryUser.sh");
		PrintUtil.println(FileUtil.read(f));
		PrintUtil.println("--------------------------------------");
		// change to yours
		File to = new File("E:/GitHub/JDK/data/queryUser2.sh");
		FileUtil.copy(f, to);
		PrintUtil.println(FileUtil.read(to));
	}

}
