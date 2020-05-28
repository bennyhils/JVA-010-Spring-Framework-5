package com.luxoft.springioc.example06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example06/application-context.xml");
		
		System.out.println("Lazy initialization on requirement:");
		Bean4 bean4 = (Bean4) context.getBean("bean4");
		System.out.println(bean4.hashCode());
          
        context.close();
    }


}
