package com.thread.synchronization1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerWithBlockingQueue_Lambda {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
		/*priya: One issue if we use lambda experssion for creating Runnable instance using lambda expression is that
		 * any variable that is present outside the lambda and used insdie lambda is final/effectively final 
		 */
		int item = new Random().nextInt(10);
		// Producer
		final Runnable producer = () -> {
			while (true) {
				try {
					System.out.println("Producer is producing: "+item);
					blockingQueue.put(item);
					Thread.sleep(2000);
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
					int consumedItem = blockingQueue.take();
					System.out.println("Consumer is consuming: "+consumedItem);
					Thread.sleep(2000);
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
