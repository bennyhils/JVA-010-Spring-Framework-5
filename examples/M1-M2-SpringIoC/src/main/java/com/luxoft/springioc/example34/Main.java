package com.luxoft.springioc.example34;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		context.getEnvironment().setActiveProfiles("production");
		context.load("classpath:example34/*.xml");
		context.refresh();
		Bean bean = (Bean)context.getBean("bean");
		
		System.out.println("a=" + bean.getA());
		
		context.close();
    }
}
