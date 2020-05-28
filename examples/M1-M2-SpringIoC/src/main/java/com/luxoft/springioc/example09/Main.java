package com.luxoft.springioc.example09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example09/application-context.xml");

		Company itCompany = (Company) context.getBean("itCompany");
		Company serviceCompany = (Company) context.getBean("serviceCompany");
		System.out.println(itCompany == serviceCompany);

		context.close();
	}

}
