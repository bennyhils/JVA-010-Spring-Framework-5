package com.luxoft.springdb.example04;

import java.util.List;

public interface BookDao {
	public void printAll();
	public void insert(Book book);
	public void update(int id, String title);
	public void delete(Book book);
	public Book getById(int id);
	public List<Book> getAll();
}
