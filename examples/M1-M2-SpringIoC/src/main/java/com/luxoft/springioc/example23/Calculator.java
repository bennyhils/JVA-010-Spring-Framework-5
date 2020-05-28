package com.luxoft.springioc.example23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator
{
    @Autowired
    private Adder adder;

    public void makeAnOperation()
    {
        int sum = adder.add(1, 2);
        System.out.println("sum = " + sum);

    }

    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "example23/application-context.xml");

        Calculator calculator = (Calculator) context.getBean("calculator");
        System.out.println(calculator.adder.hashCode());
        calculator.makeAnOperation();

        // TODO: add multiplier to calculator and check its correctness

        context.close();
    }

}
