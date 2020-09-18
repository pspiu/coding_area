package com.thread.producer.consumer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueUsingLocksAndConditions<T> {

	private Queue blockingQueue;
	private int max_size;

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public BlockingQueueUsingLocksAndConditions(int size) {
		blockingQueue = new LinkedBlockingDeque<T>();
		this.max_size = size;
	}

	public void put(T t) throws InterruptedException {
		lock.lock();
		try {
			if (blockingQueue.size() == max_size) {
				notFull.await();
			}
			blockingQueue.add(t);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (blockingQueue.size() == 0) {
				notEmpty.await();
			}
			T item=(T)blockingQueue.poll();
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}
	}
}
