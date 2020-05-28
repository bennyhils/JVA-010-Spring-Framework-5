package com.luxoft.springioc.example37;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigBean2.class);

		Bean1 bean1 = ctx.getBean(Bean1.class);
		Bean2 bean2 = ctx.getBean(Bean2.class);
		
		bean1.print();
		bean2.print();
		
		ctx.close();
	}

}
