package com.luxoft.springaop.example3;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.luxoft.springaop.example2.LoggingAspect;

@Aspect
@Component
public class ExceptionAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@AfterThrowing(pointcut="execution(* *(..))", throwing="exception")
	public void processException(RuntimeException exception) throws Throwable {
		System.out.println("----> here");
		logger.severe(exception.getMessage());
	}

}