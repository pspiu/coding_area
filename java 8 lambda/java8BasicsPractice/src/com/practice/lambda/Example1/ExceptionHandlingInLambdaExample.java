package com.practice.lambda.Example1;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambdaExample {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int key = 2;
		process(arr, key, (v, k) -> System.out.println(v + k));
		// priya: divide by zero can come now: how to handle it?
		key = 0;

		// Way-1: not a good practice to intorduce try-catch here (still better than
		// introducing at interface level for specific Exceptions; makes it bulky
		process(arr, key, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (ArithmeticException e) {
				System.out.println("Divide by zero err..oops");
			}
		});

		// Way-2:
		process(arr, key, wrapperLambda((v, k) -> System.out.println(v / k)));

	}

	private static void process(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : arr) {
			consumer.accept(i, key);
		}

	}

	//priya: can be used to wrap try catch logiv here
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println("Exception caught divide by zero");
			}
		};
	}
}
