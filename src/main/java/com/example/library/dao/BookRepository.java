package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();

    List<Book> findBookByBookId(Long BookId);

    List<Book> findBookByTitle(String title);

    List<Book> findBookByAuthors(String author);

    List<Book> findBookByIsbn(String isbn);

    List<Book> findBookByPublishingHouse(String publishingHouse);

    List<Book> findBookByPlaceOfDeploy(String placeOfDeploy);

    List<Book> findBookByPrice(BigDecimal price);

    List<Book> findAllByIsAvailableTrue();

    void deleteBookByBookId(Long bookId);

    boolean existsBookByBookId(Long bookId);

    boolean existsBookByTitle(String title);

    boolean existsBookByAuthors(String authors);

    boolean existsBookByIsbn(String isbn);

    boolean existsBookByPublishingHouse(String publishingHouse);

    boolean existsBookByPlaceOfDeploy(String placeOfDeploy);

    boolean existsBookByPrice(BigDecimal price);

}
