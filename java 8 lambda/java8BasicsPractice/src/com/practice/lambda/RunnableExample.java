package com.practice.lambda;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread created using Annonymous Inner Class");

			}
		});
		myThread1.start();
		Thread myThread2 = new Thread(() -> System.out.println("Thread created using Lambda Expression")
		);
		myThread2.start();
	}
}
