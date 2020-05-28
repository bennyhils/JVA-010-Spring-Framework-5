package com.luxoft.springioc.example10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example10/application-context.xml");

		Person smithPerson = (Person)context.getBean("smithPerson");
		System.out.println(smithPerson.getName());
        System.out.println(smithPerson.getCompany().getName());
          
        context.close();
    }


}
