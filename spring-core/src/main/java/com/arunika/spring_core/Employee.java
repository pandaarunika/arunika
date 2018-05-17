package com.arunika.spring_core;

public class Employee {

	 String name;
	 int id;
	 Department dept;
	
	public Employee() {
		System.out.println("Employee Object created");
	}
	
	public Employee(Department deptmt){
		this.dept=deptmt;
		System.out.println("constructor injection");
	}
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept1) {
		this.dept = dept1;
		System.out.println("setter injection");
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void init() {
		System.out.println("in init");
	}

	public void destroy() {
		System.out.println("in destroy");
	}
}
