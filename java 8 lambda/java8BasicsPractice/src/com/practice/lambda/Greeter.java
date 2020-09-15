package com.practice.lambda;

public class Greeter {

	private void greet(Greeting greeting) {
		greeting.perform();
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		//Way-1 Class object
		HelloWorldGreeting hwg = new HelloWorldGreeting();
		new Greeter().greet(hwg);

		//Way-2 Lambda expression
		Greeting myLambdaFunction = () -> System.out.println("Hello World using lambda");
		myLambdaFunction.perform();
		
		//Way-3 Annonymous Inner Class
		Greeting innerClassGreeting = new Greeting() {

			@Override
			public void perform() {
				System.out.println("Hello world using AIC");

			}
		};
		innerClassGreeting.perform();
	}
}
