package com.luxoft.jva010.data.repositories;

import com.luxoft.jva010.orm.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PASBookDao extends PagingAndSortingRepository<Book, Integer>, JpaRepository<Book, Integer> {

}
