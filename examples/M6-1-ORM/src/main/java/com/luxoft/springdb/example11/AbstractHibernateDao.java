package com.luxoft.springdb.example11;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class AbstractHibernateDao<T> extends HibernateDaoSupport implements Dao<T>
{

    private Class<T> clazz;

    public void setClazz(final Class<T> clazzToSet)
    {
        this.clazz = clazzToSet;
    }

    public List<T> getAll()
    {
        return getHibernateTemplate().loadAll(clazz);
    }

    @Transactional
    public void insert(final T entity)
    {
        getHibernateTemplate().save(entity);
    }

    @Transactional
    public void delete(final T entity)
    {
        getHibernateTemplate().delete(entity);
    }

}
