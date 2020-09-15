package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));

		// Example1: For each element of persons, print them
		System.out.println("Print all persons");
		persons.stream().forEach(p -> System.out.println(p.getFname()));

		// Example 2: For each element of person, first filter out elements with last
		// name starting with 'S'
		// and then print only those elements' first name
		System.out.println("Prit first name of persons whose last name starts with 'S'");
		persons.stream().filter(p -> p.getLastname().startsWith("S")).forEach(p -> System.out.println(p.getFname()));

		System.out.println("Print using parallel stream");
		persons.parallelStream().forEach(System.out::println);
		/*
		 * priya: stream()" it streams the collection and then we can have multiple
		 * operations to perform for each element of the stream and each operation has a
		 * chance to modify the elements of the stream for the next operation
		 */
	}
}

/*
A stream consists of 3 diff ele:
1. source (collection) to provide element to stream
2. operation (filter())
3. terminal (count(),forEach())

With streams, we can take iteration out of our control (no external iterators).
Runtime does iteration on its own, We're just telling the intent. Do this or that for every element.

Advantage??
DIfferent portions of Collection handled in different processor.
For it, ise parallelStream
*/