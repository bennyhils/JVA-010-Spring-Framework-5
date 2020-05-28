package com.luxoft.springdb.example01;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {


		BookDao bookDaoImpl = new BookDaoImpl();
		Book book = createBook();
		TablesManager.dropTable();
		TablesManager.createTable();

		BookServiceImpl bookService = new BookServiceImpl();
		bookService.setBookDao(bookDaoImpl);


		bookDaoImpl.insert(book);
		bookDaoImpl.printAll();
		bookDaoImpl.update(1, "Java 8");
		bookDaoImpl.printAll();
		
		Book copyBook = bookDaoImpl.getById(1);
		System.out.println("Extracted book: " + copyBook);
		
		bookDaoImpl.delete(book);
		bookDaoImpl.printAll();
	}

	private static Book createBook() {
		Book book = new Book();
		book.setTitle("Java");
		book.setDateRelease(Calendar.getInstance().getTime());
		return book;
	}

}
