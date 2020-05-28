package com.luxoft.springioc.example31;

public class Employee {
	private String surname;
	private String firstName;
	
	public Employee(String surname, String firstName) {
		this.surname = surname;
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
