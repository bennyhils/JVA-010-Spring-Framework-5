package com.luxoft.jva010.orm;

import java.time.LocalDate;
import java.util.List;

import com.luxoft.jva010.orm.dao.Dao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luxoft.jva010.orm.model.Book;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class BookDaoImplTest {

	@Autowired
	private Dao bookDao;

	@Test
	public void testSaveBooks()
	{
		String titleToCheck = "Java";

		Book exampleBook = new Book(titleToCheck, LocalDate.now());

		bookDao.save(exampleBook);

		List<Book> booksList = bookDao.getAll();
		displayBooks(booksList);

		bookDao.save(new Book("Spring", LocalDate.now()));

		booksList = bookDao.getAll();
		displayBooks(booksList);

		assertEquals(exampleBook, bookDao.getByTitle(titleToCheck));
	}

	public static void displayBooks(List<Book> allBooks)
	{
		System.out.println("\nBooks:\n");

		if (allBooks.size() > 0)
		{
			System.out.println(allBooks);
			System.out.println("--------------------------------------------------");
			System.out.println("total books in db: " + allBooks.size());
			System.out.println("--------------------------------------------------");
		}
		else
		{
			System.out.println("--------------------------------------------------");
			System.out.println("our library is empty");
			System.out.println("--------------------------------------------------");
		}

	}

}
