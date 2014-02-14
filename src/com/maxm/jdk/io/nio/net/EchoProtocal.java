package com.maxm.jdk.io.nio.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import com.maxm.jdk.util.PrintUtil;

public class EchoProtocal {

	public static final String UTF8 = "utf-8";
	public static final int BUFFER_CAPACITY = 1024;
	private static ByteBuffer BUF;

	private Selector sel;
	private SelectionKey sk;

	private EchoProtocal(Selector sel, SelectionKey sk) {
		super();
		this.sel = sel;
		this.sk = sk;
	}

	public static EchoProtocal create(Selector sel, SelectionKey sk) {
		return new EchoProtocal(sel, sk);
	}

	public void handle() throws IOException {
		if (sk.isAcceptable()) {
			doAccept();
		} else if (sk.isReadable()) {
			BUF = doRead();
		} else if (sk.isWritable()) {
			// simple echo
			doWrite(BUF);
		}
	}

	public void doAccept() throws IOException {
		ServerSocketChannel server = (ServerSocketChannel) sk.channel();
		server.configureBlocking(false);
		SocketChannel client = server.accept();
		client.configureBlocking(false);
		client.register(sel, SelectionKey.OP_READ);
		// PrintUtil.println("conn from: " + client.getLocalAddress());
	}

	public ByteBuffer doRead() throws IOException {
		SocketChannel client = (SocketChannel) sk.channel();
		ByteBuffer bb = ByteBuffer.allocate(BUFFER_CAPACITY);
		int read = client.read(bb);
		sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		if (read == -1) {
			PrintUtil.println("the channel has reached end-of-stream,close");
			client.close();
		} else {
			byte[] data = bb.array();
			if (data.length > 0) {
				PrintUtil.println("client req:" + new String(data, UTF8));
			}
		}
		return bb;
	}

	public void doWrite(ByteBuffer bb) throws IOException {
		SocketChannel client = (SocketChannel) sk.channel();
		sk.interestOps(SelectionKey.OP_READ);
		bb.flip();
		client.write(bb);
		client.close();
	}

}
