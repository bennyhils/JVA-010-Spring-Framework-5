package com.luxoft.jva010.orm.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.luxoft.jva010.orm.dao.AbstractJpaDao;
import com.luxoft.jva010.orm.model.Book;

@Repository
public class BookJpaDaoImpl extends AbstractJpaDao implements BookDao
{

    public void save(Book book)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
        entityManager.persist(book);
		entityManager.getTransaction().commit();

        if (entityManager != null)
        {
            entityManager.close();
        }
    }

    public List<Book> getAll()
    {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Book> bookList = entityManager.createQuery("from Book", Book.class)
                .getResultList();
        if (entityManager != null)
        {
            entityManager.close();
        }
        return bookList;
    }

    public Book getBookByTitle(String title)
    {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();

        if (entityManager != null)
        {
            entityManager.close();
        }

        return book;
    }

}
