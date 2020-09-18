package com.practice.lambda.Example1;

public class MethodRefExample1 {
	
public static void main(String[] args) {
	//Way-1
	/*
	 * When we have no argument to pass in lambda exprn before -> and we're just calling a method after ->
	 * -or-
	 * When all the arguments before -> are same as those after -> in method call, we can use method-ref
	 * See way-2
	 */
	Thread t=new Thread(()->printMessage());
	t.start();
	
	//Way-2
	/*
	 * We are telling java runtime that the printMessage() is basically
	 * a pass through.
	 * 
	 */
	Thread t1=new Thread(MethodRefExample1::printMessage);
	t1.start();
}

public static void printMessage() {
System.out.println("Hello");
}
}
