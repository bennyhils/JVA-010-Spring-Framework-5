package com.luxoft.springdb.example11;

import java.util.List;
import com.luxoft.springdb.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.luxoft.springdb.Utils.createBook;
import static com.luxoft.springdb.Utils.displayBooks;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("example11/application-context.xml");

		Dao bookDao = context.getBean(Dao.class);
		Book book = createBook();
		bookDao.insert(book);

		List<Book> allBooks = bookDao.getAll();
		displayBooks(allBooks);


		String niceNewTitle = "New Features in Java";

		if (allBooks.size() > 0)
		{
			book = allBooks.get(0);

			System.out.println("\nUpdating book: " + book + "\n");
			bookDao.update(book.getId(), niceNewTitle);
		}

		displayBooks(bookDao.getAll());

		System.out.println("\nLooking for a book by title...\n");
		System.out.println("\nResult: " + bookDao.findByProperty(niceNewTitle));

		System.out.println("\nRemoving book: " + book + "\n ");
		bookDao.delete(book);

		displayBooks(bookDao.getAll());
	}
}
