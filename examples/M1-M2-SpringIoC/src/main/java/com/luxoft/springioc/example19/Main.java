package com.luxoft.springioc.example19;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example19/application-context.xml");
		
		ExampleBean classic = (ExampleBean)context.getBean("classic");
        System.out.println(classic.getEmail());
        
        ExampleBean pnamespace = (ExampleBean)context.getBean("p-namespace");
        System.out.println(pnamespace.getEmail());
        
        Person john_classic = (Person)context.getBean("john-classic");
        System.out.println(john_classic.getName());
        System.out.println(john_classic.getSpouse().getName());
        
        Person john_modern = (Person)context.getBean("john-modern");
        System.out.println(john_modern.getName());
        System.out.println(john_modern.getSpouse().getName());
        
        Person jane = (Person)context.getBean("jane");
        System.out.println(jane.getName());
        
        context.close();
    }


}
