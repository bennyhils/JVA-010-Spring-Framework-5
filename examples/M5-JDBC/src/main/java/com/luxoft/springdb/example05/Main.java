package com.luxoft.springdb.example05;

import java.util.Calendar;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example05/application-context.xml");

		BookDaoImpl bookDaoImpl = (BookDaoImpl) context.getBean("bookDaoImpl");
		Book book = createBook();
		TablesManager.dropTable();
		TablesManager.createTable();
		bookDaoImpl.insert(book);
		bookDaoImpl.printAll();

		bookDaoImpl.update(1, "Java 8");
		bookDaoImpl.printAll();

		List<Book> allBooks = bookDaoImpl.getAll();
		System.out.println(allBooks.size());
		for (Book currentBook : allBooks) {
			System.out.println(currentBook);
		}

		Book copyBook = bookDaoImpl.selectBookByName("Java 8");
		System.out.println("Extracted book: " + copyBook);

		bookDaoImpl.delete(book);
		bookDaoImpl.printAll();

		context.close();
	}

	private static Book createBook() {
		Book book = new Book();
		book.setTitle("Java");
		book.setDateRelease(Calendar.getInstance().getTime());
		return book;
	}

}
