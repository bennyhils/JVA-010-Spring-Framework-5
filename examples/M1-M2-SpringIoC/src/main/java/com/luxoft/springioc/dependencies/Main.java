package com.luxoft.springioc.dependencies;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dependencies/application-context.xml");

        BankApplication bankApplication =
                (BankApplication) context.getBean("bankApplication");


        System.out.println(bankApplication.getCompanyReport().getCompany().getName());

        context.close();
    }

}
