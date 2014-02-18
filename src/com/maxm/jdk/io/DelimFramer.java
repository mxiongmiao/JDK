package com.maxm.jdk.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 基于定界符的成帧与解析
 */
public class DelimFramer implements Framer {
	private static final byte DELIMTER = '\n';

	private InputStream in;

	public DelimFramer(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
		for (byte b : msg) {
			if (b == DELIMTER) {
				throw new IOException("msg contains delimiter");
			}
		}
		out.write(msg);
		out.write(DELIMTER);
		out.flush();
	}

	@Override
	public byte[] nextMsg() throws IOException {
		ByteArrayOutputStream msgBuff = new ByteArrayOutputStream();

		int nextByte;
		while ((nextByte = in.read()) != DELIMTER) {
			if (nextByte == -1) {
				if (msgBuff.size() == 0) {
					return null;
				} else {
					throw new EOFException("non empty msg without delimiter");
				}
			}
			msgBuff.write(nextByte);
		}
		return msgBuff.toByteArray();
	}
}
