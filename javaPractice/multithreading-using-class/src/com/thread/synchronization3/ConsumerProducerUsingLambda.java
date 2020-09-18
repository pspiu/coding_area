package com.thread.synchronization3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ConsumerProducerUsingLambda {

	private static final int MAX_SIZE =5;

	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<>();

		
		new Thread(()-> {
			while (true) {
				synchronized(sharedQueue) {
					while (sharedQueue.size() ==5) {
						try {
							System.out.println("Producer is waiting for consumer to comsume ..");
							sharedQueue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
					Random random = new Random();
					int data = random.nextInt(MAX_SIZE);
					sharedQueue.add(data);
					System.out.println("Produced::"+data);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sharedQueue.notify();
				}
			}

		},"Producer").start();
		
		new Thread(()->{
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
		},"Consumer").start();
	}
}
