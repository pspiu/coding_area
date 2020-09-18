package com.thread.practice;

public class SynchronizationExample {
	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++)
					c.counter();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++)
					c.counter();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(c.val);
	}
}

class Counter {
	int val;

	/* priya: w/o synchronized keyword, output will be <=20000; sometimes not exaclty 20000
	 * This is because t1 and t2 threads are trying to access counter() where firstly val is inc and then the inc value is assigned back to val.
	 * Both threads try to access the val at same time and hence prob.
	 */
	
	public synchronized void counter() {
		val++;
	}
}
