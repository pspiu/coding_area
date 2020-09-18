package com.thread.practice;

public class DriverClass {
	public static void main(String[] args) throws InterruptedException {
		Fruits fruits=new Fruits();
		Vegetables vegetables=new Vegetables();
		fruits.start();
		// priya: to introduce delay b/w two threads. Firstly thread for fruits is started and afterwards for vegetables
		Thread.sleep(10);
		vegetables.start();
		}

}
