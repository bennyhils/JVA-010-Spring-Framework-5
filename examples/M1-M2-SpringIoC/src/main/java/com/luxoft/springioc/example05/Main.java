package com.luxoft.springioc.example05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springioc.ClientService;

public class Main {
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext("example05/client-service-non-static-factory-method.xml");

        ClientService clientService = (ClientService)context.getBean("clientService");
        System.out.println(clientService);
        
        context.close();
    }


}
