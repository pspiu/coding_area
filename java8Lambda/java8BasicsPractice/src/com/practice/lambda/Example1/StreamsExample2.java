package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.List;

public class StreamsExample2 {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));

		// print the count of elements whose first name starts with 'P'
		long count = persons.stream().filter(p -> p.getFname().startsWith("P")).count();
		System.out.println("Count: " + count);
	}
}
