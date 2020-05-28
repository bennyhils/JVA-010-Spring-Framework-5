package com.luxoft.springioc.example23;

import org.springframework.stereotype.Component;

@Component
public class Adder
{
    public int add(int a, int b)
    {
        return a + b;
    }
}
