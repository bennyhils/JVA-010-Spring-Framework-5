package com.luxoft.jva010.data.repositories;

import com.luxoft.jva010.orm.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CrudBookDao extends CrudRepository<Book, Integer> {

	Book findByTitle(String title);

	List<Book> findByDateReleaseBetween(Date start, Date end);

	List<Book> findAllByOrderByTitleAsc();

    @Query("select b from Book b where b.dateRelease = (select max(b1.dateRelease) from Book b1) ")
	Book getLatestBook();

}
