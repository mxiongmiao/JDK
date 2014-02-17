package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.maxm.jdk.util.PrintUtil;

public class UdpEchoClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(3000);
		byte[] buf = "hello udp".getBytes("utf-8");
		int len = buf.length;
		InetAddress server = InetAddress.getByName("localhost");

		DatagramPacket send = new DatagramPacket(buf, len, server, 11111);
		DatagramPacket receive = new DatagramPacket(new byte[len], len);

		boolean resp = false;
		int trys = 0;
		while (!resp && trys < 5) {
			socket.send(send);
			try {
				socket.receive(receive);
				if (!receive.getAddress().equals(server)) {
					throw new IOException("packet from unknown source");
				}
				resp = true;
			} catch (InterruptedIOException e) {
				trys += 1;
				PrintUtil.println("time out, left tries " + (5 - trys));
			}
		}

		if (resp) {
			PrintUtil.println(new String(receive.getData(), "utf-8"));
		}

		socket.close();
	}
}
