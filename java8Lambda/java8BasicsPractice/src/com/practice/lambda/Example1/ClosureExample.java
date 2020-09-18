package com.practice.lambda.Example1;

public class ClosureExample {
	public static void main(String[] args) {
		int a = 10;
		/*
		 * priya: Here, b is effectively final, means inside anonnymous class/lamba
		 * created below, if we use it its value is used as defined but we're no allowed
		 * to modify the value. Before Java 8, we must declare it as final.
		 */
		int b = 20;

		doProcess(a, (x) -> System.out.println("Lambda expr: " + (x + b)));

		doProcess(a, new Process() {

			@Override
			public void process(int x) {
				System.out.println("Annonymous class" + (x + b));
			}
		});
	}

	private static void doProcess(int x, Process p) {
		p.process(x);
	}

	interface Process {
		void process(int i);
	}
}
