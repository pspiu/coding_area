package comparable_comparator;

import java.io.*;
import java.util.*;

//Driver class 
class CompartorExample1 {
	public static void main(String[] args) {
		ArrayList<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("Priya", 9.3, 500000));
		list.add(new Emp("Monika", 8.7, 60000));
		list.add(new Emp("Prajwal", 8.8, 1980));
		list.add(new Emp("Dhiraj", 9.1, 1983));

		Comparator<Emp> ratingComparator = new RatingComparator();
		Collections.sort(list, ratingComparator);

		System.out.println("Emps after sorting based on rating: ");
		//Way-1: for in loop external iteration
		for (Emp Emp : list) {
			System.out.println(Emp.getName() + " " + Emp.getRating() + " " + Emp.getsalary());
		}
		Comparator<Emp> nameComparator = new NameComparator();
		Collections.sort(list, nameComparator);
		System.out.println("Emps after sorting based on names: ");
		//Way-2: forEach() internal iteration
		list.stream().forEach(e -> System.out.println(e.getName() + " " + e.getRating() + " " + e.getsalary()));

	}
}

// A class 'Emp' that implements Comparable 
class Emp {
	private double rating;
	private String name;
	private int salary;

	// Constructor
	public Emp(String nm, double rt, int sal) {
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

class RatingComparator implements Comparator<Emp> {

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.getRating() >= o2.getRating() ? -1 : 1;
	}
}

class NameComparator implements Comparator<Emp> {
	public int compare(Emp e1, Emp e2) {
		return e1.getName().compareTo(e2.getName());
	}
}