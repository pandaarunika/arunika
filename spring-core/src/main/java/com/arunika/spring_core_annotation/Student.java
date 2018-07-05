package com.arunika.spring_core_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	private String name;
	private int roll;
	@Autowired	
	@Qualifier(value="Subjects1")
	private Subjects s;
	
	public Student(){
		System.out.println("student created");
	}
	public Student(Subjects s){
		this.s= s;
	}
	public String getName() {
		return name;
	}
	public Subjects getS() {
		return s;
	}
	
	/*@Autowired	
	public void setS(Subjects s) {
		this.s = s;
		System.out.println("Injected Subject through setter");
	}*/
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
}
