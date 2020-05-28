package com.luxoft.springioc.example29;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

public class Bean implements ApplicationListener<CustomEvent>
{

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("CustomEvent received");
	}

}
