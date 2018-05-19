package com.arunika.spring_core;

import java.util.List;

public class Employee {

	String name;
	int id;
	InnerBeanEx inbean;
	Department dept;
	List shiftList;

	

	public Employee() {
		System.out.println("Employee Object created");
	}

	public Employee(Department deptmt) {
		this.dept = deptmt;
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

	public InnerBeanEx getInbean() {
		return inbean;
	}

	public void setInbean(InnerBeanEx inbean) {
		this.inbean = inbean;
		inbean.setBeanName("inner bean");
	}
	
	public List getShiftList() {
		return shiftList;
	}

	public void setShiftList(List shiftList) {
		this.shiftList = shiftList;
	}

	public void init() {
		System.out.println("in init");
	}

	public void destroy() {
		System.out.println("in destroy");
	}
}
