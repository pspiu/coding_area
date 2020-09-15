package com.thread.practice;

public class Fruits implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
