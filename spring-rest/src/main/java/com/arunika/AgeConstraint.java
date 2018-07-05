package com.arunika;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
	 String message() default "Invalid age";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
}
