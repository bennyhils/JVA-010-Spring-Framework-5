package com.luxoft.springaop.example3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
			    new ClassPathXmlApplicationContext("example3/aop.xml");
		
		UserDaoImpl userDao = (UserDaoImpl)context.getBean("userDao");
		System.out.println(userDao.getUser(0));
		
		// TODO: process exception so that next line was shown
		System.out.println("Exception should be processed");
		context.close();
	}

}
