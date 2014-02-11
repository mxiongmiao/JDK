package com.maxm.jdk.io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.maxm.jdk.util.PrintUtil;

public class FileRead {
	private static final String lineSeperator = System.lineSeparator();
	private StringBuilder data = new StringBuilder();

	public FileRead() {
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

	private void close(Closeable br) throws IOException {
		if (br != null) {
			br.close();
		}
	}

	public static void main(String[] args) throws IOException {
		File f = new File("E:/快盘/work/rekoo/my脚本/queryUser.sh");
		FileRead fr = new FileRead();
		fr.read(f);
		PrintUtil.println(fr.data);
	}
}
