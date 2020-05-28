package com.luxoft.springioc.example23;

import org.springframework.stereotype.Service;

@Service
public class Multiplier
{
    public int multiply(int a, int b)
    {
        return a * b;
    }
}
