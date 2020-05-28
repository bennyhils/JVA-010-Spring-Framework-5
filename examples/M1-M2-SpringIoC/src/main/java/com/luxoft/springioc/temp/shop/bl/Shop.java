package com.luxoft.springioc.temp.shop.bl;

import com.luxoft.springioc.temp.shop.Product;

public class Shop
{
    private StorageService service;

    public Shop()
    {
    }

    public Shop(StorageService service)
    {
        this.service = service;
    }

    public void addToStorage(Product p)
    {
        this.service.store(p);
    }

    public void setService(StorageService service)
    {
        this.service = service;
    }
}
