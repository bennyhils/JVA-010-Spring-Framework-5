package com.luxoft.springioc.example18;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example18/application-context.xml");
		
		ExampleBean exampleBean = (ExampleBean)context.getBean("exampleBean");
        System.out.println(exampleBean.getName());
        System.out.println(exampleBean.getEmail());
        
        context.close();
    }


}
