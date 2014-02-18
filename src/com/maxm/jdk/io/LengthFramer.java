package com.maxm.jdk.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 基于长度的成帧与解析<br>
 * TODO
 */
public class LengthFramer implements Framer {

	@Override
	public void frameMsg(byte[] msg, OutputStream out) throws IOException {
	}

	@Override
	public byte[] nextMsg() throws IOException {
		return null;
	}

}
