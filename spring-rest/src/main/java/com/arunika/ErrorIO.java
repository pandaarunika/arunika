package com.arunika;

public class ErrorIO {
	private int errorCode;
	private String message;
	public ErrorIO(){
	}
	public ErrorIO(String message){
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
