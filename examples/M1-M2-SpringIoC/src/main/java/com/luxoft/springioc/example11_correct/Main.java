package com.luxoft.springioc.example11_correct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example11_correct/application-context.xml");

		System.out.println(context.getBean("a"));

		context.close();
	}
}
