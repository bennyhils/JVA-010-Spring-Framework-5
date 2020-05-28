package com.luxoft.springioc.example16;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example16/application-context.xml");
		
		TestBean derivedTestBean = (TestBean)context.getBean("inheritsWithDifferentClass");
        System.out.println(derivedTestBean.getName());
        System.out.println(derivedTestBean.getAge());
        
        context.close();
    }


}
