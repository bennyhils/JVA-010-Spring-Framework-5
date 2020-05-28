package com.luxoft.springaop.example1;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
//	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Pointcut("execution(* *.*User(..))")
    public void userMethod()
    {
        System.out.println(" --> never called ");
    }

	@Around("userMethod()")
	public Object log (ProceedingJoinPoint thisJoinPoint) throws Throwable
    {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        print("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        print("Method " + methodName + " returns " + result);

        return result;
	}

    private void print(String toLog) {
        System.out.println(toLog);
    }

}