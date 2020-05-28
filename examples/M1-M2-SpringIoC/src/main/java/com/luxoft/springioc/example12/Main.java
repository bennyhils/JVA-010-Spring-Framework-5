package com.luxoft.springioc.example12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example12/application-context.xml");

		  Person smithPerson = (Person)context.getBean("smithPerson");
          System.out.println(smithPerson.getCompany().getName());
          System.out.println(smithPerson.getName());
          
          context.close();
    }


}
