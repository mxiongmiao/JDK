package com.maxm.jdk.thread;

public class TestReadWriteLock {
	public static void main(String[] args) {
		new Thread(new Hook()).start();
		new Thread(new Writer()).start();
		new Thread(new Reader()).start();
	}
}
