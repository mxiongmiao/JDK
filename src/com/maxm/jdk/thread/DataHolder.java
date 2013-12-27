package com.maxm.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataHolder {
	public static int count = 0;
	public static ReadWriteLock rwLock = new ReentrantReadWriteLock();
}
