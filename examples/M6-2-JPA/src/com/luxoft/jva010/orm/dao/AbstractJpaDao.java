package com.luxoft.jva010.orm.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public abstract class AbstractJpaDao
{

    protected EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }

}