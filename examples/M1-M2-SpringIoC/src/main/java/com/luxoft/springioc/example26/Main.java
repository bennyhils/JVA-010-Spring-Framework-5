package com.luxoft.springioc.example26;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example26/application-context.xml");

		Bean bean = (Bean) context.getBean("bean");
		System.out.println(bean.hashCode());

		context.close();
	}

}
