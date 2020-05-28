package com.luxoft.springdb.tx.orm;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.springdb.tx.data.repositories.BookDao;
import com.luxoft.springdb.tx.orm.model.Book;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class BookDaoImplTest {

	private Book exampleBook = new Book("Java", Date.valueOf(LocalDate.of(2015, 5, 1)));

	@Autowired
	private BookDao bookDao;

	@Test
	public void testSaveBooks() {

		bookDao.save(exampleBook);
		
		System.out.println(bookDao.getClass());
		
		for (Class<?> clazz: bookDao.getClass().getInterfaces()) {
			System.out.println(clazz.getName());
		}
		
		for (Method method : bookDao.getClass().getDeclaredMethods()) {
			System.out.println(method.toGenericString());
		}

		List<Book> booksList = (List<Book>)bookDao.findAll();
		assertEquals(1, booksList.size());
		assertEquals(exampleBook, booksList.get(0));
		
		bookDao.save(new Book("Spring", Date.valueOf(LocalDate.of(2015, 5, 1))));

		bookDao.save(new Book("Spring Data", Date.valueOf(LocalDate.of(2016, 4, 1))));

		booksList = (List<Book>)bookDao.findAll();
		assertEquals(3, booksList.size());
		
		assertEquals(exampleBook, bookDao.findByTitle("Java"));

		bookDao.save(new Book("Angular", Date.valueOf(LocalDate.of(2016, 3, 1))));
		
		System.out.println("Books 2015:");
		List<Book> books2015 = bookDao.findByDateReleaseBetween(Date.valueOf(LocalDate.of(2015, 1, 1)), 
				Date.valueOf(LocalDate.of(2015, 12, 31)));
		books2015.forEach(System.out::println);
		
		System.out.println("Books sorted by title:");
		List<Book> books = bookDao.findAllByOrderByTitleAsc();
		books.stream().map(book->book.getTitle()).forEach(System.out::println);
		
		System.out.println("Latest book:");
		System.out.println(bookDao.getLatestBook());
		
		bookDao.setPublishingHouse("Luxoft Publishing");
		bookDao.findAll().forEach(System.out::println);
		
		for (Book book : bookDao.findAll()) {
			assertEquals("Luxoft Publishing", book.getPublishingHouse());
		}
	}

}
