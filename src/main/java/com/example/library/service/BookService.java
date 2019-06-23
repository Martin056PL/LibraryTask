package com.example.library.service;

import com.example.library.domain.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    List<Book> returnFullListOfBooks();

    List<Book> findBookByBookId(Long bookId);

    List<Book> findBookByTitle(String title);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByISBN(String isbn);

    List<Book> findBookByPlaceOfDeploy(String placeOfDeploy);

    List<Book> findBookByPublishingHouse(String publishingHouse);

    List<Book> findBookByPrice (BigDecimal price);

    void deleteBookByBookId(Long bookId);



}
