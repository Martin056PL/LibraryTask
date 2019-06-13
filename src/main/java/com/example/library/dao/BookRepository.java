package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findBookByTitle(String title);

    List<Book> findBookByAuthors(String author);

}
