package com.luxoft.springaop.patterns.decorator;

import com.luxoft.springaop.patterns.base.Animal;
import com.luxoft.springaop.patterns.base.Cat;

public class CatDecorator implements Animal
{

    private Cat cat;

    public CatDecorator(Cat cat)
    {
        this.cat = cat;
    }

    public void voice()
    {
        System.out.println("Checking cat...");
        System.out.println("He is not angry.");
        cat.voice();
        System.out.println("Cat went home.");
    }
}
