package com.luxoft.jva010.mvc.model;

public class Address
{
    private Long id;

    private String city;
    private String street;

    public Address() {}

    public Address(Long id, String city, String street)
    {
        this.id = id;
        this.city = city;
        this.street = street;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }
}
