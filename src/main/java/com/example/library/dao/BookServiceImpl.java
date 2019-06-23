package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Autowired
    BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> returnFullListOfBooks(){
        return repository.findAll();

    }
    @Override
    public List<Book> findBookByBookId(Long bookId){
        if(checkIfAvailableByBookId(bookId)){
        return repository.findBookByBookId(bookId);
        }else throw new IllegalArgumentException();
    }
    @Override
    public List<Book> findBookByTitle(String title){
        if(checkIfAvailableByTitle(title)){
            return repository.findBookByTitle(title);
        }else throw new IllegalArgumentException();

    }
    @Override
    public List<Book> findBookByAuthor(String author){
        if(checkIfAvailableByAuthor(author))
        return repository.findBookByAuthors(author);
        else throw new IllegalArgumentException();
    }
    @Override
    public List<Book> findBookByISBN(String isbn){
        if(checkIfAvailableByISBN(isbn)) {
            return repository.findBookByIsbn(isbn);
       }else throw new IllegalArgumentException();
    }
    @Override
    public List<Book> findBookByPlaceOfDeploy(String placeOfDeploy){
        if(checkIfAvailableByPlaceOfDeploy(placeOfDeploy)) {
            return repository.findBookByPlaceOfDeploy(placeOfDeploy);
        }else throw new IllegalArgumentException();
    }
    @Override
    public List<Book> findBookByPublishingHouse(String publishingHouse){
        if(checkIfAvailableByPublishingHouse(publishingHouse)) {
            return repository.findBookByPublishingHouse(publishingHouse);
        }else throw new IllegalArgumentException();
    }
    @Override
    public List<Book> findBookByPrice (BigDecimal price){
        if(checkIfAvailableByPrice(price)) {
            return repository.findBookByPrice(price);
        }else throw new IllegalArgumentException();
    }
    @Override
    public void deleteBookByBookId(Long bookId){
        if(checkIfAvailableByBookId(bookId)){
        repository.deleteBookByBookId(bookId);
        }else throw new IllegalArgumentException();
    }

    private boolean checkIfAvailableByBookId(Long bookID){
        return repository.existsBookByBookId(bookID);
    }

    private boolean checkIfAvailableByTitle(String title){
        return repository.existsBookByTitle(title);
    }

    private boolean checkIfAvailableByAuthor(String authors){
        return repository.existsBookByAuthors(authors);
    }

    private boolean checkIfAvailableByISBN(String isbn){
        return repository.existsBookByIsbn(isbn);
    }

    private boolean checkIfAvailableByPlaceOfDeploy(String placeOfDeploy){
        return repository.existsBookByPlaceOfDeploy(placeOfDeploy);
    }

    private boolean checkIfAvailableByPublishingHouse(String publishingHouse){
        return repository.existsBookByPublishingHouse(publishingHouse);
    }

    private boolean checkIfAvailableByPrice(BigDecimal price){
        return repository.existsBookByPrice(price);
    }

    public void deleteBook(Book book) {
        repository.delete(book);
    }

}
