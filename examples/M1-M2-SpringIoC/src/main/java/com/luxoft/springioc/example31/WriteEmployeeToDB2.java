package com.luxoft.springioc.example31;

import org.springframework.context.ApplicationListener;

public class WriteEmployeeToDB2 implements ApplicationListener<EmployeeRegistrationEvent> {
	
	public void onApplicationEvent(EmployeeRegistrationEvent event) {
		System.out.println("WriteEmployeeToDB2#" + Thread.currentThread().getName());
		System.out.println("Employee " + event.getEmployee().getSurname() + " " + event.getEmployee().getFirstName() + 
				" is saved into the database");
	}

}
