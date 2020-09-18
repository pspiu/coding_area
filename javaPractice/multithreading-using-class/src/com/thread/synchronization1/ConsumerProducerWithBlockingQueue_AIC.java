package com.thread.synchronization1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducerWithBlockingQueue_AIC {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
		/*
		 * priya: One issue if we use lambda experssion for creating Runnable instance
		 * using lambda expression is that any variable that is present outside the
		 * lambda and used insdie lambda is final/effectively final
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						int item = new Random().nextInt(10);
						System.out.println("Producer is producing: " + item);
						blockingQueue.put(item);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "Prodcuer").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						int consumedItem = blockingQueue.take();
						System.out.println("Consumer is consuming: " + consumedItem);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, "consumer").start();
	}

}
