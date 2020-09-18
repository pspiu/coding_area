package com.practice.lambda.Example1;

public class Person {
	private String fname;
	private String lastname;
	int age;

	public Person(String fname, String lastname, int age) {
		super();
		this.fname = fname;
		this.lastname = lastname;
		this.age = age;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lastname=" + lastname + ", age=" + age + "]";
	}
}
