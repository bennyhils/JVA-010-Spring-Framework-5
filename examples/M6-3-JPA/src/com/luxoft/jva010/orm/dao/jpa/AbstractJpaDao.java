package com.luxoft.jva010.orm.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.luxoft.jva010.orm.dao.Dao;

public abstract class AbstractJpaDao<T> implements Dao<T>
{
    private Class<T> clazz;

    @PersistenceUnit
    protected EntityManagerFactory entityManagerFactory;

    public void setClazz(final Class<T> clazzToSet)
    {
        this.clazz = clazzToSet;
    }

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void save(final T entity)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        if (entityManager != null)
        {
            entityManager.close();
        }
    }

    public List<T> getAll()
    {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        List<T> list = (List<T>) entityManager.createQuery("from " + clazz.getName()).getResultList();
        if (entityManager != null)
        {
            entityManager.close();
        }
        return list;
    }

    public T getByTitle(String title)
    {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        @SuppressWarnings("unchecked")
        T entity = (T) entityManager.createQuery("SELECT c FROM " + clazz.getName() + " c WHERE c.title LIKE :title")
                .setParameter("title", title)
                .getSingleResult();

        if (entityManager != null)
        {
            entityManager.close();
        }

        return entity;
    }

}