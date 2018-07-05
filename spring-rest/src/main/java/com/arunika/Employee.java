package com.arunika;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Employee {
	
	@NotEmpty (message="Can't be empty")
	@NotNull (message="Cantbe null")
	private String name;
	
	@AgeConstraint
	private int age;
	
	public Employee(){
		
	}
	public Employee(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}
