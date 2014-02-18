package com.maxm.jdk.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.maxm.jdk.util.PrintUtil;

public class IoUtil {

	public static void main(String[] args) throws IOException {

		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(buf);
		dos.writeInt(2014);
		dos.writeByte(2);
		dos.writeByte(18);
		dos.flush();

		byte[] msg = buf.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(msg);
		DataInputStream dis = new DataInputStream(bais);
		int y = dis.readInt();
		int m = dis.readByte();
		int d = dis.readByte();

		PrintUtil.println(y + "-" + m + "-" + d);

		dis.close();
		bais.close();
		dos.close();
		buf.close();
	}
}
