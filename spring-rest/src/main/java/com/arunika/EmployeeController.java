package com.arunika;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	public ResponseEntity<List<Employee>>  getEmployees(){
		List<Employee> e = new ArrayList<Employee>();
		//int i=16/0;
		e.add(new Employee("Arunika",10));
		e.add(new Employee("Arya",12));
		ResponseEntity<List<Employee>>  response = new ResponseEntity<List<Employee>>(e, HttpStatus.OK);
		return response;
		
	}
	
	@RequestMapping(value="/employeeid/{age}",method=RequestMethod.GET)
	public Employee getEmployeeByAge(@PathVariable("age") int ageinint){
		List<Employee> e = new ArrayList<Employee>();
		e.add(new Employee("Arunika",10));
		e.add(new Employee("Arya",12));
		for(Employee e1:e){
			if( ageinint==e1.getAge()){
				return e1;
			}
			else{
				throw new EmployeeNotFoundException("Employee not found");
			}
		}
		return null;
	}
	
	@RequestMapping(value="/employeename/{name}",method=RequestMethod.GET)
	public Employee getEmployeeByName(@RequestParam("name") String name){
		List<Employee> e = new ArrayList<Employee>();
		e.add(new Employee("Arunika",10));
		e.add(new Employee("Arya",12));
		for(Employee e1:e){
			if( name.equals(e1.getName())){
				return e1;
			} 
		}
		return null;
	}
	
	@RequestMapping(value="/saveemployee",method=RequestMethod.POST)
	public Employee saveEmployee(@Valid @RequestBody Employee emp, BindingResult b){
		if(b.hasErrors()){
			throw new RuntimeException(b.getFieldError().getDefaultMessage());
		}
		System.out.println(emp);
		return emp;
	}
}
