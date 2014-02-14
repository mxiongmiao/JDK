package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TimeClient {

	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		sc.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8013));
		sc.close();
	}
}
