package com.luxoft.springioc.example26;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Bean implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean  {

	@Override
	public void afterPropertiesSet() {
		System.out.println("Inside afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside destroy");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println(beanName +" bean has been initialized." );	
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Bean factory " + beanFactory + " has been initialized." );
		System.out.println("bean is singleton: " + beanFactory.isSingleton("bean"));
		System.out.println("bean is prototype: " + beanFactory.isPrototype("bean"));
	}

}
