package com.luxoft.springioc.temp.shop.storage;

import com.luxoft.springioc.temp.shop.Product;
import com.luxoft.springioc.temp.shop.bl.StorageService;

public class StorageServiceImpl implements StorageService
{

    public void store(Product p)
    {
        System.out.println("stored: " + p.getName());
    }
}
