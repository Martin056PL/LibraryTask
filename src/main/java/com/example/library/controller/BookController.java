package com.example.library.controller;

import com.example.library.dao.BookService;
import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping("/get")
    public String returnFullListOfBooks(Model model){
        List<Book> books= service.returnFullListOfBooks();
        model.addAttribute("books", books);
        return "listOfBooks";
    }
}