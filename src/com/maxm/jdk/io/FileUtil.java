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
		File f = new File("E:/快盘/work/rekoo/my脚本/queryUser.sh");
		FileUtil fr = new FileUtil();
		fr.read(f);
		PrintUtil.println(fr.data);

		File f2 = new File("E:/GitHub/JDK/src/com/maxm/jdk/io/queryUser.sh");
		fr.copy(f, f2);
	}
}
