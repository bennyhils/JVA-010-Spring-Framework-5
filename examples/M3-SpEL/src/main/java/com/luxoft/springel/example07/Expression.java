package com.luxoft.springel.example07;

public class Expression {
	
	private String regEx;
	private String regExResult;
	private String numberResult;
	private String email;
	
	public Expression() {
		email = "office@luxoft.com";
	}
 
	public String getRegEx() {
		return regEx;
	}

	public void setRegEx(String regEx) {
		this.regEx = regEx;
	}
	
	public String getRegExResult() {
		return regExResult;
	}

	public void setRegExResult(String regExResult) {
		this.regExResult = regExResult;
	}

	public String getNumberResult() {
		return numberResult;
	}

	public void setNumberResult(String numberResult) {
		this.numberResult = numberResult;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegEx :  \n Does mapListStringBean.email match the ^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$ " 
	           + regExResult + "\n Is 100 a valid number ? " + numberResult;
	}

}