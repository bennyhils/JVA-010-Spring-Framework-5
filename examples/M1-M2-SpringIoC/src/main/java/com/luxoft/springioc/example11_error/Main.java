package com.luxoft.springioc.example11_error;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example11_error/application-context.xml");

		context.close();
	}
}
