package com.luxoft.springioc.example31;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmployeeService implements ApplicationContextAware {
	
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) {
		this.context = context;
	}
	
	public void registerEmployee(String surname, String firstName) {
		Employee employee = new Employee(surname, firstName);
		System.out.println("EmployeeService#" + Thread.currentThread().getName());
		context.publishEvent(new EmployeeRegistrationEvent(employee));
	}


}
