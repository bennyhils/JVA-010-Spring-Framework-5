package com.luxoft.springioc.example35;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		ClientDao dao = context.getBean("dao", ClientDao.class);
		System.out.println(dao);
		ClientService service = context.getBean(ClientService.class);
		service.doTheJob();

		BeanConfig.PersonBean person = context.getBean(BeanConfig.PersonBean.class);
		System.out.println(person.getClientDao() == dao);

		context.close();
	}

}
