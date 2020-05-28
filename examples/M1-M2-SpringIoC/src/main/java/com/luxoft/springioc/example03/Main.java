package com.luxoft.springioc.example03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springioc.ClientService;

public class Main {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example03/client-service.xml");

		ClientService clientService = (ClientService) context.getBean("clientService");
		System.out.println(clientService.hashCode());

		context.close();
	}

}
