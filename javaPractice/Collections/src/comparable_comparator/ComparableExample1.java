package comparable_comparator;

import java.io.*;
import java.util.*;

// A class 'Employee' that implements Comparable 
class Employee implements Comparable<Employee> {
	private double rating;
	private String name;
	private int salary;

	// Used to sort Employees by salary
	public int compareTo(Employee e) {
		//return this.salary - e.salary;
		//return this.name.compareTo(e.name);
		return (int) (this.rating-e.rating);
	}

	// Constructor
	public Employee(String nm, double rt, int sal) {
		this.name = nm;
		this.rating = rt;
		this.salary = sal;
	}

	// Getter methods for accessing private data
	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getsalary() {
		return salary;
	}
}

// Driver class 
class ComparableExample1 {
	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Priya", 9.3, 500000));
		list.add(new Employee("Monika", 8.7, 60000));
		list.add(new Employee("Prajwal", 8.8, 1980));
		list.add(new Employee("Dhiraj", 9.1, 1983));

		Collections.sort(list);

		System.out.println("Employees after sorting : ");
		for (Employee Employee : list) {
			System.out.println(Employee.getName() + " " + Employee.getRating() + " " + Employee.getsalary());
		}
	}
}