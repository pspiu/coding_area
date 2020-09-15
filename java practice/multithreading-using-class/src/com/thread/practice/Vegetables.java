package com.thread.practice;

public class Vegetables extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		showVegetables();
	}
	public void showVegetables() {
		int i = 1;
		while (i <= 5) {
			System.out.println("vegetable: " + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
