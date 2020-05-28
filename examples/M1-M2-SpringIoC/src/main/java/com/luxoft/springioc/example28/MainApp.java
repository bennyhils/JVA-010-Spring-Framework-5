
package com.luxoft.springioc.example28;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example28/application-context.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();

		context.close();
	}
}