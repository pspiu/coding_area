package com.thread.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerWithBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
		int num = 0;
		// Producer
		final Runnable producer = () -> {
			while (true) {
				try {
					System.out.println("Producer is putting some number");
					blockingQueue.put(num);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(producer, "Producer 1").start();
		new Thread(producer, "Producer 2").start();

		// Producer
		final Runnable consumer = () -> {
			while (true) {
				try {
					int item = blockingQueue.take();
					System.out.println("Consumer is taking some number");
					System.out.println(item);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		new Thread(consumer, "Consumer 1").start();
		// priya: can have multiple threads for consumer and producer
		new Thread(consumer, "Consumer 2").start();
		Thread.sleep(1000);
	}

}
