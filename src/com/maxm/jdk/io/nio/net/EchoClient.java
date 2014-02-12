package com.maxm.jdk.io.nio.net;

import java.nio.ByteBuffer;
import java.util.LinkedList;

/**
 * The client object. This is currently only used to queue the data waiting to
 * be written to the client.
 */
public class EchoClient {
	private LinkedList<ByteBuffer> outq;

	EchoClient() {
		outq = new LinkedList<ByteBuffer>();
	}

	// Return the output queue.
	public LinkedList<ByteBuffer> getOutputQueue() {
		return outq;
	}

	// Enqueue a ByteBuffer on the output queue.
	public void enqueue(ByteBuffer bb) {
		outq.addFirst(bb);
	}
}