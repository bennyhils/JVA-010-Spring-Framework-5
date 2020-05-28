package com.luxoft.springaop.patterns.base;

import java.util.List;

public class AnimalStore
{
    private List<Animal> animals;

    public void makeNoise()
    {
        for (Animal animal : animals)
        {
            animal.voice();
        }
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }
}
