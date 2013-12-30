package com.maxm.jdk.thread;

public class Reader implements Runnable{
	
	public Reader(){
		super();
	}

	@Override
	public void run() {
		while(true){
			DataHolder.rwLock.readLock().lock();
			System.out.println(Thread.currentThread().getName() + " 加读锁");
			try {
				Thread.sleep(1000L);
				System.out.println(Thread.currentThread().getName()+" 读线程， count == "+DataHolder.count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				System.out.println(Thread.currentThread().getName() + " 释放读锁");
				DataHolder.rwLock.readLock().unlock();
			}
		}
	}
}
