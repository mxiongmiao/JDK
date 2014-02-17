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

	public void pushMsg(E e) {
		queue.addLast(e);
	}

	public E popMsg() {
		return queue.removeFirst();
	}

	public static void main(String[] args) {
		MsgQueue<String> mq = new MsgQueue<>();
		mq.pushMsg("hi");
		mq.pushMsg("jdk");
		mq.pushMsg("1.7");

		PrintUtil.println(mq.popMsg());
		PrintUtil.println(mq.popMsg());
		PrintUtil.println(mq.popMsg());
	}
}
