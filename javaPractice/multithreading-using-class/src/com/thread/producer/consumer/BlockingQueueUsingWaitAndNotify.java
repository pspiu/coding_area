package com.thread.producer.consumer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingWaitAndNotify<T> {

	private Queue blockingQueue;
	private int max_size;

	private ReentrantLock lock = new ReentrantLock(true);
	private Object notEmpty = new Object();
	private Object notFull = new Object();

	public BlockingQueueUsingWaitAndNotify(int size) {
		blockingQueue = new LinkedBlockingDeque<T>();
		this.max_size = size;
	}

	public synchronized void put(T t) throws InterruptedException {
		if (blockingQueue.size() == max_size) {
			notFull.wait();
		}
		blockingQueue.add(t);
		notEmpty.notifyAll();
	}

	public synchronized T take() throws InterruptedException {
		/*
		 * priya; If 'if' condition is used, then there is no sync b/w 2 diff consumer
		 * threads. Suppose consumer1 takes last item as it acquires lock after
		 * notifyAll() issued by put() and there is no item now in Queue. Now consumer2
		 * acquires lock and this will give NullPointerException now. Sol: Use while
		 * loop instead.
		 */
		// if(blockingQueue.size()==0)
		while (blockingQueue.size() == 0) {
			notEmpty.wait();
		}
		T item = (T) blockingQueue.poll();
		notFull.notifyAll();
		return item;
	}
}
