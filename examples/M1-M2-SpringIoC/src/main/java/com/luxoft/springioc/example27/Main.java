package com.luxoft.springioc.example27;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
		    new ClassPathXmlApplicationContext("example27/application-context.xml");

        Bean1 bean1 = (Bean1)context.getBean("bean1");
        Bean2 bean2 = (Bean2)context.getBean("bean2");
        
        System.out.println(bean1.hashCode());
        System.out.println(bean2.hashCode());
        
        context.close();
    }


}
