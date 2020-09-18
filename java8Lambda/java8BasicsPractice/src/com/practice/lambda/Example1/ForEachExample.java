package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));

		// Way-1 uisng for loop
		System.out.println("using for-loop");
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

		// Way-2 using for-in loop
		for (Person p : persons)
			System.out.println(p);

		/*
		 * Both ways are external iterators. We're controlling the iteration
		 * (i=initialized, increment etc
		 * 
		 */

		// Way-3 Internal Iterators (in java-8): forEach()
		/*
		 * New method introduced in Java-8, we can pass 1 argument here We're telling
		 * make sure lambda executes for each iteration, we're not controlling how ?
		 * which order?
		 */
		System.out.println("Using lambda forEach");
		persons.forEach(p -> System.out.println(p));
		// or
		persons.forEach(System.out::println);
	}
}
