package com.thread.practice;

public class DriverClass {
	public static void main(String[] args) throws InterruptedException {
		
		Runnable fruits = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showFruits();
				System.out.println("fruit thread priority: "+Thread.currentThread().getPriority());
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
		};
		Runnable vegetables = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showVegetables();
				System.out.println("veg thread priority: "+Thread.currentThread().getPriority());
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
		};

		Thread fruit_thread = new Thread(fruits);
		Thread veg_thread = new Thread(vegetables);
		fruit_thread.start();
		// priya: to introduce delay b/w two threads. Firstly thread for fruits is
		// started and afterwards for vegetables
		Thread.sleep(10);
		veg_thread.start();
		veg_thread.setPriority(1);
		fruit_thread.setPriority(2);		
	}

	// priya: using lambda expression
	/*
	 * public static void main(String[] args) throws InterruptedException { Runnable
	 * fruits = () -> { int i = 1; while (i <= 5) { System.out.println("fruit: " +
	 * i++); try { Thread.sleep(1000); } catch (InterruptedException e) {
	 * e.printStackTrace(); } }
	 * 
	 * }; Runnable vegetables = () -> { int i = 1; while (i <= 5) {
	 * System.out.println("vegetable: " + i++); try { Thread.sleep(1000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } } };
	 * 
	 * Thread fruit_thread = new Thread(fruits); Thread veg_thread = new
	 * Thread(vegetables); fruit_thread.start(); // priya: to introduce delay b/w
	 * two threads. Firstly thread for fruits is // started and afterwards for
	 * vegetables Thread.sleep(10); veg_thread.start(); }
	 */

}
