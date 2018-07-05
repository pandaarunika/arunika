package com.arunika;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@ControllerAdvice
public class ExceptionHandlerAE {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleException(ArithmeticException e){
		
		System.out.println("division y zero");
		return null;
	}
	@ExceptionHandler({EmployeeNotFoundException.class}	)
	public ResponseEntity<ErrorIO> handleException(EmployeeNotFoundException e){
		ResponseEntity<ErrorIO>  response = new ResponseEntity<ErrorIO>(new ErrorIO("Employee not found") , HttpStatus.NOT_FOUND);
		System.out.println("Employee doesnot exist");
		return response ;
	}
	
	@ExceptionHandler({Throwable.class}	)
	public ResponseEntity<ErrorIO> handleGlobalException(Throwable e){
		ResponseEntity<ErrorIO>  response = new ResponseEntity<ErrorIO>(new ErrorIO(e.getMessage()) , HttpStatus.BAD_REQUEST);
		return response ;
	}
}
