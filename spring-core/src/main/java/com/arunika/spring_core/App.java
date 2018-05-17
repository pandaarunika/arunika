package com.arunika.spring_core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
	}
}
