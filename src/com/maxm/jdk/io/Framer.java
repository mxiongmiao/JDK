package com.maxm.jdk.io;

import java.io.IOException;
import java.io.OutputStream;

public interface Framer {

	/**
	 * 成帧
	 * 
	 * @param msg
	 * @param out
	 * @throws IOException
	 */
	void frameMsg(byte[] msg, OutputStream out) throws IOException;

	/**
	 * 解析
	 * 
	 * @return
	 * @throws IOException
	 */
	byte[] nextMsg() throws IOException;

}
