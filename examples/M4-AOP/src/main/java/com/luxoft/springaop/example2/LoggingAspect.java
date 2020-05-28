package com.luxoft.springaop.example2;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("@annotation(com.luxoft.springaop.example2.Log)")
	public Object log (ProceedingJoinPoint thisJoinPoint) throws Throwable
    {
        System.out.println("--> Here");

        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        logger.info("Call method " + methodName + " with args " + methodArgs);
        Object result = thisJoinPoint.proceed(); 
        logger.info("Method " + methodName + " returns " + result);
        return result;
	}

}