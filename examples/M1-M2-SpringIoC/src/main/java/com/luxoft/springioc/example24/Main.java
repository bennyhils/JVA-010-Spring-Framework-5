package com.luxoft.springioc.example24;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
		    new ClassPathXmlApplicationContext("example24/application-context.xml");

        Bean bean1 = (Bean)context.getBean("bean");
        Bean bean2 = (Bean)context.getBean("bean");
        Bean bean3 = (Bean)context.getBean("bean");
        Bean bean4 = (Bean)context.getBean("bean");
        System.out.println(bean1 == bean2);
        System.out.println(bean1 == bean3);
        System.out.println(bean1 == bean4);
          
        context.close();
    }


}
