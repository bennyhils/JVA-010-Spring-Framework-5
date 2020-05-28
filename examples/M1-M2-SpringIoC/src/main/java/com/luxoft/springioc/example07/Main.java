package com.luxoft.springioc.example07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example07/application-context.xml");
		Message message = (Message)context.getBean("message"); 
		Theme theme = (Theme)context.getBean("theme"); 
		
//		Ex1TestBean bean1 = (Ex1TestBean)context.getBean("bean1");
//		Bean2 bean2 = (Bean2)context.getBean("bean2");
//
//        System.out.println(message.hashCode());
//        System.out.println(theme.hashCode());
//        System.out.println(bean1.hashCode());
//        System.out.println(bean2.hashCode());
//

		System.out.println(theme.getName());
		context.close();
    }

}
