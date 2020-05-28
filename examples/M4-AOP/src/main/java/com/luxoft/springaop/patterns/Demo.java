package com.luxoft.springaop.patterns;

import com.luxoft.springaop.patterns.base.Animal;
import com.luxoft.springaop.patterns.base.AnimalStore;
import com.luxoft.springaop.patterns.base.Cat;
import com.luxoft.springaop.patterns.decorator.CatDecorator;
import com.luxoft.springaop.patterns.proxy.CatProxy;

import java.util.ArrayList;
import java.util.List;

public class Demo
{

    public static void main(String[] args)
    {
        List<Animal> animals = new ArrayList<Animal>();


        animals.add(new Cat());
        animals.add(new Cat());

        animals.add(new CatProxy(new Cat()));
        animals.add(new CatDecorator(new Cat()));

        AnimalStore animalStore = new AnimalStore();
        animalStore.setAnimals(animals);

        animalStore.makeNoise();
    }
}
