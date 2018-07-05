package com.arunika;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeConstraint, Integer> {

	  
	  public void initialize(AgeConstraint age) {
	  }

	  
	  public boolean isValid(Integer ageField, ConstraintValidatorContext cxt) {
	      if(ageField !=null && ageField >0 && ageField<101){
	    	  return true;
	      }
		return false;
	  }

}