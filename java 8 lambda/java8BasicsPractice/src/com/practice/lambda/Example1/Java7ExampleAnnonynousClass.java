package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7ExampleAnnonynousClass {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));

		// Step-1: Sort list by last name
		System.out.println("Print all persons sorted by lastname");
		Collections.sort(persons, (p1, p2) -> p1.getLastname().compareTo(p2.getLastname()));
		// Step-2: Create a method that prints all elements in the list
		// Way-1:
		printAll(persons);
		// Way-2
		printConditionally(persons, p -> true);
		// Step-3: Create a method that prints elements with last name beginning with S
		// and first name beginning with P
		System.out.println("Lastname ends with S");
		printConditionally(persons, p -> p.getLastname().startsWith("S"));
		System.out.println("Firstname starts with P");
		printConditionally(persons, p -> p.getFname().startsWith("P"));
	}

	private static void printConditionally(List<Person> persons, Condition condition) {
		for (Person p : persons) {
			if (condition.test(p))
				System.out.println(p);
		}
	}

	private static void printAll(List<Person> persons) {
		for (Person p : persons)
			System.out.println(p);

	}

	public interface Condition {
		boolean test(Person p);
	}
}
