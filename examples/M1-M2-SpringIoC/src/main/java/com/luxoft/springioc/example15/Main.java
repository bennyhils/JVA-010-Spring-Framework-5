package com.luxoft.springioc.example15;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example15/application-context.xml");
		
		Customer customerBean = (Customer)context.getBean("customerBean");
        System.out.println(customerBean.hashCode());
        System.out.println(customerBean.getList().getClass().getName());
        System.out.println(customerBean.getList().size());
        System.out.println(customerBean.getSet().size());
        System.out.println(customerBean.getMap().getClass().getName());
        System.out.println(customerBean.getMap().keySet().size());
        System.out.println(customerBean.getMap().values().size());
        System.out.println(customerBean.getStringsMap().getClass().getName());
        System.out.println(customerBean.getStringsMap().keySet().size());
        System.out.println(customerBean.getStringsMap().values().size());
        System.out.println(customerBean.getPersonsMap().getClass().getName());
        System.out.println(customerBean.getPersonsMap().keySet().size());
        System.out.println(customerBean.getPersonsMap().values().size());
        System.out.println(customerBean.getProps().keySet().size());
        System.out.println(customerBean.getProps().values().size());
        
        context.close();

    }


}
