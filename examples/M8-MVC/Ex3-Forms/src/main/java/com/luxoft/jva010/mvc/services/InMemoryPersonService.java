package com.luxoft.jva010.mvc.services;

import com.luxoft.jva010.mvc.model.Person;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPersonService implements PersonService
{
    private long nextId;

    private Map<Long, Person> cache;

    public InMemoryPersonService()
    {
        cache = new HashMap<>();
        nextId = 1;
    }

    @PostConstruct
    public void init()
    {
        Person p = new Person(nextId++, "Oleg", 100000);
        cache.put(p.getId(), p);

        p = new Person(nextId++, "Irina", 50000);
        cache.put(p.getId(), p);

        p = new Person(nextId++, "Nikolay", 30000);
        cache.put(p.getId(), p);

    }

    @Override
    public Person getById(Long id)
    {
        return cache.get(id);
    }

    @Override
    public Person save(Person person)
    {
        if (person.getId() == null)
        {
            person.setId(nextId++);
        }

        cache.put(person.getId(), person);

        return person;
    }

    @Override
    public List<Person> getAll()
    {
        return new ArrayList<>(cache.values());
    }
}
