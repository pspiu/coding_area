package com.thread.synchronization2;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable{

	private Queue<Integer> sharedQueue;

	public Consumer(Queue<Integer> q) {
		this.sharedQueue = q;
	}

	public void run() {
		
		while (true) {
			synchronized(sharedQueue) {
				while (sharedQueue.isEmpty()) {
					try {
						System.out.println("Consumer is waiting for Producer to produce ..");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				int data = sharedQueue.poll();
				System.out.println("Consumed::"+data);
				sharedQueue.notify();
			}
		}

	}
}
