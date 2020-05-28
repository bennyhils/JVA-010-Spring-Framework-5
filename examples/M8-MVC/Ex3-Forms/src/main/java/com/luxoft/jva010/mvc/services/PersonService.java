package com.luxoft.jva010.mvc.services;

import com.luxoft.jva010.mvc.model.Person;

import java.util.List;

public interface PersonService
{
    Person getById(Long id);

    Person save(Person person);

    List<Person> getAll();
}
