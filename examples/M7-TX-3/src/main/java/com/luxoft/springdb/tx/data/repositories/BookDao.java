package com.luxoft.springdb.tx.data.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luxoft.springdb.tx.orm.model.Book;

public interface BookDao extends JpaRepository<Book, Integer>, BookDaoCustom {

	public Book findByTitle(String title);
	public List<Book> findByDateReleaseBetween(Date start, Date end);
	public List<Book> findAllByOrderByTitleAsc();
	
	@Query("select b from Book b where b.dateRelease = (select max(b1.dateRelease) from Book b1) ")
	Book getLatestBook();
}
