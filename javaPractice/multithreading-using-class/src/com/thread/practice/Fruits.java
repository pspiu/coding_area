package com.thread.practice;

public class Fruits extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		showFruits();
	}
	public void showFruits() {
		int i = 1;
		while (i <= 5) {
			System.out.println("fruit: " + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
