package com.luxoft.springioc.example08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example08/application-context.xml");

          DataSource dataSource = (DataSource)context.getBean("dataSource");
          System.out.println(dataSource.getDriverClassName());
          System.out.println(dataSource.getUrl());
          System.out.println(dataSource.getUsername());
          System.out.println(dataSource.getPassword());
          
          context.close();
    }


}
