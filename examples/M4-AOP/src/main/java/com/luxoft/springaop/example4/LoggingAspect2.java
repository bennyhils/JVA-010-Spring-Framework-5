package com.luxoft.springaop.example4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggingAspect2 {
	
	@Pointcut("execution(* get*())")
    public void allGetters() {
		System.out.println("-->");
	}
	
	@Before("allGetters()")
	public void loggingAdviceGetter() {
		System.out.println("--> Advice run. A getter method will be called from LoggingAspect2");
	}

}
