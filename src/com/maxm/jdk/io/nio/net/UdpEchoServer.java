package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpEchoServer {
	private static final int ECHOMAX = 255;
	private static final int SERVERPORT = 11111;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(SERVERPORT);
		byte[] buf = new byte[ECHOMAX];
		DatagramPacket packet = new DatagramPacket(buf, ECHOMAX);

		while (true) {
			ds.receive(packet);
			ds.send(packet);
			packet.setLength(ECHOMAX);
		}
	}
}
