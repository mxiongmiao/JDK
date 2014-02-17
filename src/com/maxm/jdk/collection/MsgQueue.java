package com.maxm.jdk.collection;

import java.util.LinkedList;

import com.maxm.jdk.util.PrintUtil;

// 简单消息队列 
// TODO 完善功能
public class MsgQueue<E> {
	private LinkedList<E> queue;

	public MsgQueue() {
		super();
		queue = new LinkedList<>();
	}

	public void addMsg(E e) {
		queue.addLast(e);
	}

	public E delMsg() {
		return queue.removeFirst();
	}

	public static void main(String[] args) {
		MsgQueue<String> mq = new MsgQueue<>();
		mq.addMsg("hi");
		mq.addMsg("jdk");
		mq.addMsg("1.7");

		PrintUtil.println(mq.delMsg());
		PrintUtil.println(mq.delMsg());
		PrintUtil.println(mq.delMsg());
	}
}
