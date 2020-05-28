package com.luxoft.springioc.example31;

import org.springframework.context.ApplicationEvent;

public class EmployeeRegistrationEvent extends ApplicationEvent {
	private static final long serialVersionUID = 4527120861846308745L;
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	
	public EmployeeRegistrationEvent(Employee employee) {
		super(employee);
		this.employee = employee;
	}
}

