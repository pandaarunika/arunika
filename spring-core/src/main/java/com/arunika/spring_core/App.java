package com.arunika.spring_core;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arunika.spring_core_annotation.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//Employee e = context.getBean(Employee.class);
		//Employee e =(Employee) context.getBean("e1");
		//System.out.println(e.name);
		Employee e =(Employee) context.getBean("employee");
		System.out.println(e.name);
		System.out.println(e.id);
		System.out.println(e.getDept().getDptName());
		System.out.println(e.getInbean().getBeanName());
		List<String> shift = e.getShiftList();
		for(String s:shift){
			System.out.println(s);
		}	
		Student s1 =( Student)context.getBean("Student");
		System.out.println(s1.getS().getName());
		
	}
}
