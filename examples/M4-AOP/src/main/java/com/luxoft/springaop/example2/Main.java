package com.luxoft.springaop.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
			    new ClassPathXmlApplicationContext("example2/aop.xml");
		
		UserDaoImpl userDao = (UserDaoImpl)context.getBean("userDao");
		System.out.println(userDao.getUser(1));
		
		context.close();
	}

}
