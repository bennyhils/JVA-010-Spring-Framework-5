package com.luxoft.jva010.orm;

import com.luxoft.jva010.data.repositories.PASBookDao;
import com.luxoft.jva010.orm.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class PASBookDaoTest {

    private Book exampleBook = new Book("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));

    @Autowired
    private PASBookDao pasBookDao;

    @Test
    public void testSaveBooks() {

        pasBookDao.save(exampleBook);

        List<Book> booksList = pasBookDao.findAll();

        assertEquals(1, booksList.size());
        assertEquals(exampleBook, booksList.get(0));

        pasBookDao.save(new Book("Spring", Date.valueOf(LocalDate.of(2015, 5, 1))));

        pasBookDao.save(new Book("Spring Data", Date.valueOf(LocalDate.of(2016, 4, 1))));

        pasBookDao.save(new Book("Angular", Date.valueOf(LocalDate.of(2016, 3, 1))));

        booksList = pasBookDao.findAll();
        assertEquals(4, booksList.size());

        System.out.println();
        System.out.println("--> Books sorted by title:");
        List<Book> books = pasBookDao.findAll(new Sort("title"));
        books.stream().map(book -> book.getTitle() + ":" + book.getDateRelease()).forEach(System.out::println);

        System.out.println();
        System.out.println("--> Books sorted by dateRelease:");
        books = pasBookDao.findAll(new Sort(Sort.Direction.DESC, "dateRelease"));
        books.stream().map(book -> book.getTitle() + ":" + book.getDateRelease()).forEach(System.out::println);

        System.out.println();
        Page<Book> booksPage = pasBookDao.findAll(new PageRequest(0, 2));
        System.out.println("--> Books page: " + booksPage.getNumber()  + " from: " + booksPage.getTotalPages());
        booksPage.map(book -> book.getTitle()).forEach(System.out::println);

        System.out.println();
        booksPage = pasBookDao.findAll(new PageRequest(1, 2));
        System.out.println("--> Books page: " + booksPage.getNumber()  + " from: " + booksPage.getTotalPages());
        booksPage.map(book -> book.getTitle()).forEach(System.out::println);

    }


}
