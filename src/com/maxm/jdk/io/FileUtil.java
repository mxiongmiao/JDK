package com.maxm.jdk.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.maxm.jdk.util.PrintUtil;

public class FileUtil {
	private static final String lineSeperator = System.lineSeparator();
	private StringBuilder data = new StringBuilder();

	public FileUtil() {
		super();
	}

	public void read(File f) throws IOException {
		if (data.length() > 0) {
			data.setLength(0);
		}
		InputStream in = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(in,
				"utf-8"));
		for (;;) {
			String readLine = br.readLine();
			if (readLine == null) {
				break;
			}
			data.append(readLine).append(lineSeperator);
		}
		close(br);
		close(in);
	}

	public void copy(File from, File to) throws IOException {
		// bio 的话直接从 fin 中读取，而nio会从fin的通道中读取
		FileChannel fci = new FileInputStream(from).getChannel();
		FileChannel fco = new FileOutputStream(to).getChannel();

		// like ByteBuffer.allocate(1024)
		// byte[] b = new byte[1024];
		// ByteBuffer bf = ByteBuffer.wrap(b);

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		for (;;) {
			// 从输入通道读取数据到缓冲区
			buffer.clear();
			int r = fci.read(buffer);
			if (r == -1) {
				break;
			}
			// 将当期那缓冲区内容写入输出通道
			buffer.flip();
			fco.write(buffer);
		}
	}

	private void close(Closeable br) throws IOException {
		if (br != null) {
			br.close();
		}
	}

	public static void main(String[] args) throws IOException {
		File f = new File("E:/GitHub/JDK/src/com/maxm/jdk/io/queryUser.sh");
		FileUtil fr = new FileUtil();
		fr.read(f);
		PrintUtil.println(fr.data);

		File f2 = new File("E:/GitHub/JDK/src/com/maxm/jdk/io/queryUser2.sh");
		fr.copy(f, f2);

		// 构建并填充一缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		PrintUtil.println("limit:" + buffer.limit());
		for (int i = 0; i < buffer.capacity(); i++) {
			buffer.put((byte) i);
		}
		// 创建子缓冲区(分片)
		buffer.position(1);
		buffer.limit(3);
		ByteBuffer slice = buffer.slice();
		for (int i = 0; i < slice.capacity(); i++) {
			byte b = slice.get(i);
			b *= 2;
			slice.put(i, b);
		}
		// 查看原来缓冲区内容
		buffer.position(0);
		buffer.limit(buffer.capacity());
		while (buffer.remaining() > 0) {
			PrintUtil.println(buffer.get());
		}
	}
}
