package com.practice.lambda.Example1;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample ref = new ThisReferenceExample();

		/* priya: here also printing this will cause error bcz we can't use this in
		// static methods
		// System.out.println(this);
		// AIC example
		 */
		ref.doProcess(10, new Process() {
			@Override
			public void process(int i) {
				System.out.println("Val of i: " + i);
				System.out.println(this);
			}
		});

		// lambda expression
		ref.doProcess(10, i -> {
			System.out.println(i);
			// priya: it will throw error as this is not overriden in lambda exprn and we're
			// inside a static method (no obj)
			// System.out.println(this);
		});

		ref.thisRefNoOverrride();
	}

	public void thisRefNoOverrride() {
		doProcess(10, i -> {
			System.out.println("Val of i " + i);
			// priya: no error as here, this points to reference using which the
			// thisRefNoOverrride() method is called(ThisReferenceExampleo obect)
			System.out.println(this);
		});
	}

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public String toString() {
		return "This is the main ThisReferenceExample ref class";
	}
}

interface Process {
	void process(int i);
}
