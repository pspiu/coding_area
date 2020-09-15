package com.practice.lambda.Example1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodRefExample2 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Priya", "Singh", 26), new Person("Monika", "Badgujjar", 25),
				new Person("Prajwal", "Gabru", 20));
		System.out.println("printing all persons");

		// Way-1
		printConditionally(persons, p -> true, p -> System.out.println(p));
		// Way-2
		/*
		 * Way-1 can be replaced by a method-ref. When compiler identifies a method ref,
		 * it identifies that System.out takes place of Predicate and it is simply
		 * calling a method with one argument
		 */
		printConditionally(persons, p -> true, System.out::println);
	}

	private static void printConditionally(List<Person> persons, Predicate<Person> condition,
			Consumer<Person> consumer) {
		for (Person p : persons) {
			if (condition.test(p))
				consumer.accept(p);
		}
	}
}
