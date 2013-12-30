package com.maxm.jdk.thread;

public class Writer implements Runnable{
	@Override
	public void run() {
		while(true){
			DataHolder.rwLock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + " 加写锁");
			
			try {
				DataHolder.count++;
				System.out.println("执行 count++");
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				System.out.println(Thread.currentThread().getName() + " 释放写锁");
				DataHolder.rwLock.writeLock().unlock();
			}
		}
	}
}
