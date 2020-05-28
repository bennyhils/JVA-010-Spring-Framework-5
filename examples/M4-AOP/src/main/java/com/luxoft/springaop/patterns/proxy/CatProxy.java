package com.luxoft.springaop.patterns.proxy;

import com.luxoft.springaop.patterns.base.Animal;
import com.luxoft.springaop.patterns.base.Cat;

public class CatProxy implements Animal
{

    private Cat cat;

    public CatProxy(Cat cat)
    {
        this.cat = cat;
    }

    public void voice()
    {
        System.out.println("Can't access this method.");
//        cat.voice();
    }
}
