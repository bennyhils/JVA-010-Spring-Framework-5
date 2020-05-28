package com.luxoft.springioc.example23;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator {
    private Adder adder;
    private Multiplier multiplier;


    private Calculator(Adder adder, Multiplier multiplier) {
        this.adder = adder;
        this.multiplier = multiplier;
    }

    public void makeAnOperation() {
        int sum = adder.add(1, 2);
        System.out.println("sum = " + sum);

    }

    public void multiply() {
        int mult = multiplier.multiply(9, 9);
        System.out.println("mult = " + mult);
    }

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.luxoft.springioc.example23");

        Calculator calculator = (Calculator) context.getBean("calculator");
        System.out.println(calculator.adder.hashCode());
        calculator.makeAnOperation();

        System.out.println(calculator.multiplier.hashCode());
        calculator.multiply();
    }

}
