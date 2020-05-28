package com.luxoft.springioc.example29;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext(
				"example29/application-context.xml");

//		CommandManager commandManager =
//				(CommandManager) context.getBean("commandManager");
//		commandManager.getApplicationContext()
//				.publishEvent(new CustomEvent("test"));

		context.close();
	}
}
