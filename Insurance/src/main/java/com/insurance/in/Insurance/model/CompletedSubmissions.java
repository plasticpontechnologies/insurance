package com.insurance.in.Insurance.model;

public class CompletedSubmissions {
	private String name;
	private String position;
	private int age;
	private String start_date;
	private String salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "CompletedSubmissions [name=" + name + ", position=" + position + ", age=" + age + ", start_date="
				+ start_date + ", salary=" + salary + "]";
	}

}
