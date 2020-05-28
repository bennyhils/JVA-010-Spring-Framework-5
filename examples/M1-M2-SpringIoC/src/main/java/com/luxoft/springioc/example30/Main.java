package com.luxoft.springioc.example30;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
		    new ClassPathXmlApplicationContext("example30/application-context.xml");
		
		CommandManager commandManager = (CommandManager)context.getBean("commandManager");
		commandManager.getApplicationContext().publishEvent(new CustomEvent(new Object()));
		
		context.close();
		
    }
}
