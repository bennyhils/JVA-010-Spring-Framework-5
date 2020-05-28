package com.luxoft.springioc.temp;

public class LuxoftCompany extends Company {
	private static Company luxoftCompany = new Company();
	
	public LuxoftCompany() {
		 luxoftCompany.setName("Luxoft");
	}
	
	public static Company getCompany() {
		return luxoftCompany;
	}

}
