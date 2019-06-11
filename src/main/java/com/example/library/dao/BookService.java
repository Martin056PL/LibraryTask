package com.example.library.dao;

import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookService {

    private BookRepository repository;

    @Autowired
    BookService(BookRepository repository){
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addBook(){
        List<String> authorList = new ArrayList<>();
        authorList.add("Sienkiewicz");
        authorList.add("Boczarski");

        Book book = new Book.BookBuilder()
                .setTitle("Asd")
                .setAuthors(authorList)
                .setISBN("123-123D-123")
                .setPlaceOfDeploy("Warsaw")
                .setPublishingHouse("PWN")
                .setPrice(BigDecimal.valueOf(89.90))
                .build();


        System.out.println(book);
        repository.save(book);
    }

    public void deleteBook(Book book){
        repository.delete(book);
    }

}
