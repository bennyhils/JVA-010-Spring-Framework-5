package com.luxoft.springioc.temp;

public class SmithPerson {
	private static Person smithPerson = new Person();
	
	public static Person getPerson() {
		smithPerson.setName("John Smith");
		smithPerson.setCompany(LuxoftCompany.getCompany());
		return smithPerson;
	}
}
