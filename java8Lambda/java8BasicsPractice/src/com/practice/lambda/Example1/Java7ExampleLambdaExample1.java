package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7ExampleLambdaExample1 {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));

		// Step-1: Sort list by last name
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastname().compareTo(o2.getLastname());
			}
		});
		// Step-2: Create a method that prints all elements in the list
		printAll(persons);

		// Step-3: Create a method that prints elements with last name beginning with S
		// and first name beginning with P
		System.out.println("Lastname ends with S");
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastname().startsWith("S");
			}

		});
		System.out.println("Firstname starts with P");
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getFname().startsWith("P");
			}

		});
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
