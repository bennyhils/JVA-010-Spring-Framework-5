package com.luxoft.springioc.example10;

public class Person {
	private String name;
	private Company company;
	
	public Person(String name, Company company) {
		this.name = name;
		this.company = company;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

}
