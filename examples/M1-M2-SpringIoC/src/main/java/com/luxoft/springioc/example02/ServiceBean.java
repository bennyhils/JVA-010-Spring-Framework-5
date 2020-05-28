package com.luxoft.springioc.example02;

import java.util.Arrays;

public class ServiceBean implements Service
{
    private Dao dao;

    @Override
    public void printNames()
    {
        System.out.println(Arrays.toString(dao.getData()));
    }

    public void setDao(Dao dao)
    {
        this.dao = dao;
    }
}
