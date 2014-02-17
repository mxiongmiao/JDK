package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpEchoServer {
	private static final int ECHOMAX = 255;
	private static final int SERVERPORT = 11111;

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(SERVERPORT);
		byte[] buf = new byte[ECHOMAX];
		DatagramPacket dp = new DatagramPacket(buf, ECHOMAX);

		while (true) {
			ds.receive(dp);
			ds.send(dp);
			dp.setLength(ECHOMAX);
		}
	}
}
