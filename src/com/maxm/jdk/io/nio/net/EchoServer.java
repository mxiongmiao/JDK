package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

import com.maxm.jdk.util.PrintUtil;

// TODO 度量服务器处理时间
public class EchoServer {
	int port;

	public EchoServer(int port) {
		this.port = port;
	}

	private void start() throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.bind(new InetSocketAddress(InetAddress.getLocalHost(), 12345));

		Selector sel = Selector.open();
		ssc.register(sel, SelectionKey.OP_ACCEPT);

		for (;;) {
			sel.select();
			Iterator<SelectionKey> itor = sel.selectedKeys().iterator();
			while (itor.hasNext()) {
				SelectionKey sk = itor.next();
				itor.remove();

				if (!sk.isValid()) {
					PrintUtil.println("invalid event:" + sk);
					continue;
				}

				EchoProtocal.create(sel, sk).handle();
			}
		}
	}

	public static void main(String[] args) {
		try {
			new EchoServer(12345).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
