package com.example.library.service;

import com.example.library.dao.BookRepository;
import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
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

    public void addBook(Book book){
        repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteBookByBookId(id);
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


    //@EventListener(ApplicationReadyEvent.class)
    public void addBook(){
        List<String> authorList = new ArrayList<>();
        authorList.add("Christian Bauer");
        authorList.add("Gavin King");
        authorList.add("Gary Gregory");

        Book book = new Book.BookBuilder()
                .setTitle("Java Persistance")
                .setAuthors(authorList)
                .setISBN("978-83-283-2782-5")
                .setPlaceOfDeploy("Gliwice")
                .setPublishingHouse("Helion")
                .setPrice(BigDecimal.valueOf(99.00))
                .build();


        System.out.println(book);
        repository.save(book);
    }

}
