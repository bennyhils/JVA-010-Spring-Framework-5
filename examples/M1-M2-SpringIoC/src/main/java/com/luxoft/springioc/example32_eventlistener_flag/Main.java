package com.luxoft.springioc.example32_eventlistener_flag;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"example32_eventlistener_flag/application-context.xml");

		CommandManager commandManager = (CommandManager) context.getBean("commandManager");
		commandManager.getApplicationContext().publishEvent(new CustomEvent(new Object(), true));
		commandManager.getApplicationContext().publishEvent(new CustomEvent(new Object(), false));

		context.close();
	}
}
