package com.luxoft.springioc.xtests;

import org.springframework.beans.factory.annotation.Autowired;

public class Lifecycle
{
    private String cArg;

    @Autowired
    private A prop;

    public Lifecycle(String cArg)
    {
        this.cArg = cArg;
        System.out.println("Lifecycle#Constructor");
        System.out.println("Lifecycle#Constructor: " + prop);
    }

    public void init()
    {
        System.out.println("Lifecycle#init");
        System.out.println("Lifecycle#init: " + prop);
    }
}
