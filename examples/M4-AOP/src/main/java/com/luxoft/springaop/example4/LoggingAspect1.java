package com.luxoft.springaop.example4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class LoggingAspect1 {
	
	@Before("execution(public String com.luxoft.springaop.example4.Triangle.getName())")
	public void loggingAdviceGetName() {
		System.err.println("Advice run. getName method will be called");
	}
	
    @Before("execution(public * *.draw())")
	public void loggingAdviceDraw() {
		System.err.println("Advice run. draw method will be called");
	}
    
    @Pointcut("execution(* get*())")
    public void allGetters() {
    	
    }
    
    @Before("allGetters()")
	public void loggingAdviceGetter() {
		System.err.println("Advice run. A getter method will be called from LoggingAspect1");
	}
    
    @Pointcut("within(com.luxoft.springaop.example4.Circle)")
    public void allCircleMethods() {
    	
    }
    
    @After("allCircleMethods()")
    public void loggingAdvice(JoinPoint jointPoint) {
    	System.err.println("Advice run. A circle method had been called.");
    	System.err.println(jointPoint.toString());
    	System.err.println(jointPoint.getTarget());
    }
    
    @AfterReturning("args(name)")
    public void stringArgumentMethods(String name) {
    	System.err.println("A method that takes String arguments has been called. The value is " + name);
    }
    
    @AfterThrowing(pointcut="args(name)", throwing="exception")
    public void exceptionAdvice(String name, RuntimeException exception) {
    	System.err.println("An exception has been thrown " + exception + " Name to set is: " + name);
    }

}