package com.practice.lambda;

public class TypeInferenceExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Way-1 If there is only 1 arg, no need for () and {}
		StringLenLambda myLamda1 = (s1) -> s1.length();
		StringLenLambda myLamda = s -> s.length();
		System.out.println(myLamda.getLen("Hello World"));
		//Way-2
		printLambda(s -> s.length());

	}

	public static void printLambda(StringLenLambda l) {
		System.out.println(l.getLen("Hello World"));
	}

	interface StringLenLambda {
		int getLen(String s);
	}
}
