package com.thread.practice;

public class DriverClass {
	public static void main(String[] args) throws InterruptedException {
		Runnable fruits=new Fruits();
		Runnable vegetables=new Vegetables();
		
		Thread fruit_thread=new Thread(fruits);
		Thread veg_thread=new Thread(vegetables);
		fruit_thread.start();
		// priya: to introduce delay b/w two threads. Firstly thread for fruits is started and afterwards for vegetables
		Thread.sleep(10);
		veg_thread.start();
		}

}
