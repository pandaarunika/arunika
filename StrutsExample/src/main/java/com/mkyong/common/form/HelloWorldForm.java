package com.mkyong.common.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm{
	
	String message;
	String name;
	String gender;
	Boolean indian;
	String city[];
	public String[] getCity() {
		return city;
	}

	public void setCity(String[] city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIndian() {
		return indian;
	}

	public void setIndian(Boolean indian) {
		this.indian = indian;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}