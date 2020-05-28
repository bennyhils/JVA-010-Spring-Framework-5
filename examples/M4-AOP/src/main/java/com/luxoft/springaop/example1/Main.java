package com.luxoft.springaop.example1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
			    new ClassPathXmlApplicationContext("example1/aop.xml");
		
		UserDao userDao = (UserDao)context.getBean("userDao");
		System.out.println("---> " + userDao.getUser(1));
		
		context.close();
	}

}
