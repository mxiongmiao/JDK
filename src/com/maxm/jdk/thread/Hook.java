package com.maxm.jdk.thread;

public class Hook implements Runnable{
	
	@Override
	public void run() {
		while(true){
			DataHolder.rwLock.readLock().lock();
			System.out.println(Thread.currentThread().getName() + " 钩子 加读锁 ");
			try {
				Thread.sleep(1000L);
				if(DataHolder.count > 3){
					System.out.println("jvm 退出");
					System.exit(0);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				System.out.println(Thread.currentThread().getName() + " 钩子 释放读锁");
				DataHolder.rwLock.readLock().unlock();
			}
		}
	}
}
