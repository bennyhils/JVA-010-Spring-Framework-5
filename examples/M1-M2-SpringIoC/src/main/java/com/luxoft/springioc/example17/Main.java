package com.luxoft.springioc.example17;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example17/application-context.xml");

		ComplexObject complexObject = (ComplexObject) context.getBean("child");
		complexObject.getAdminEmails().forEach((key, value) -> System.out.println(key + ": " + value));

		Thread.sleep(1000);

//		System.out.println(complexObject.getAdminEmails().get("administrator"));
//		System.out.println(complexObject.getAdminEmails().get("sales"));
//		System.out.println(complexObject.getAdminEmails().get("support"));

		context.close();
	}

}
