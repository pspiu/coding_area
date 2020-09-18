package com.thread.synchronization2;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer_implements_Runnable {

	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<>();

		new Thread(new Producer(sharedQueue), "Producer").start();
		new Thread(new Consumer(sharedQueue), "Consumer").start();
	}
}
