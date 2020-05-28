package com.luxoft.springioc.example04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springioc.ClientService;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example04/client-service-factory-method.xml");

        ClientService clientService = (ClientService)context.getBean("clientService");
        System.out.println(clientService);

        context.close();
    }


}
