package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    private BookRepository repository;

    @Autowired
    BookService(BookRepository repository) {
        this.repository = repository;
    }


    //@EventListener(ApplicationReadyEvent.class)
    public void addBook() {
        List<String> authorList = new ArrayList<>();
        authorList.add("Strączke");
        authorList.add("Świtoniak");
        authorList.add("Fajanczek");

        Book book = new Book.BookBuilder()
                .setTitle("Absolut")
                .setAuthors(authorList)
                .setISBN("123-123D-123")
                .setPlaceOfDeploy("Warsaw")
                .setPublishingHouse("PWN")
                .setPrice(BigDecimal.valueOf(89.90))
                .build();


        System.out.println(book);
        repository.save(book);
    }

    public List<Book> returnFullListOfBooks(){
        return repository.findAll();

    }

    public List<Book> returnBookByTitle(String title){
        return repository.findBookByTitle(title);
    }

    public List<Book> findBookByAuthor(String author){
        return repository.findBookByAuthors(author);
    }

    public void deleteBook(Book book) {
        repository.delete(book);
    }

}
