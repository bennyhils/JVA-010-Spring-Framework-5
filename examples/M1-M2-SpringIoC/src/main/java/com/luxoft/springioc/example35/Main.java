package com.luxoft.springioc.example35;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		ClientService service = context.getBean(ClientService.class);
		service.doTheJob();

		context.close();
	}

}
