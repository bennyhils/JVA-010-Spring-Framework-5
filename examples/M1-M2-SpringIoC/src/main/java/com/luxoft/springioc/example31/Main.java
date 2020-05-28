package com.luxoft.springioc.example31;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String args[])
    {
        System.out.println("Main#" + Thread.currentThread().getName());

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("example31/application-context.xml");

        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        employeeService.registerEmployee("Smith", "John");
        employeeService.removeEmployee("Smith", "John");


        System.out.println("Main end#" + Thread.currentThread().getName());
        context.close();

    }
}
