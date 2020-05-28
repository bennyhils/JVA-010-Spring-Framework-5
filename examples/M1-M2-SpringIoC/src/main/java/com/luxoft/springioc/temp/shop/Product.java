package com.luxoft.springioc.temp.shop;

/**
 * Created by oyushche on 12/28/17.
 */
public class Product
{
    private String name;

    public Product()
    {
    }

    public Product(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
