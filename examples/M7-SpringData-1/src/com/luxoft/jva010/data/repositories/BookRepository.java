package com.luxoft.jva010.data.repositories;

import com.luxoft.jva010.orm.model.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book, Integer> {

    Book findByTitle(String title);

}
