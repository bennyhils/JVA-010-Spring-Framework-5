package com.luxoft.jva010.mvc.model;

import java.util.Objects;

public class Person
{
    private Long id;

    private String name;

    private int money;

    public Person()
    {
    }

    public Person(long id, String name, int money)
    {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Person person = (Person) o;
        return money == person.money &&
                Objects.equals(id, person.id) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, name, money);
    }
}
