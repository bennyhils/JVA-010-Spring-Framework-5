package com.luxoft.springel.example08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("expressionBean")
public class Expression {

	@Value("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String regEx;

	@Value("#{(expressionBean.email matches expressionBean.regEx)== true ? '-Yes there is a match.' : '-No there is no match.' }")
	private String regExResult;

	@Value("#{ ('100' matches '\\d+') == true ? '-Yes this is digit.' : '-No this is not a digit.' }")
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