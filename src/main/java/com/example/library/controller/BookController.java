package com.example.library.controller;

import com.example.library.dao.BookService;
import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping("/getAll")
    public String returnFullListOfBooks(Model model) {
        List<Book> books = service.returnFullListOfBooks();
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/getByTitle/{title}")
    public String returnBookByTitle(Model model, @PathVariable(value = "title") String title) {
        List<Book> books = service.returnBookByTitle(title);
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/getByAuthor/{author}")
    public String returnBookByAuthor(Model model, @PathVariable(value = "author") String author) {
        List<Book> books = service.findBookByAuthor(author);
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/deleteBookByBookId/{bookId}")
    @Transactional
    public String deleteBookByBookId(Model model, @PathVariable(value = "bookId") String bookId) {
        try {
            service.deleteBookByBookId(Long.parseLong(bookId));
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        List<Book> books = service.returnFullListOfBooks();
        model.addAttribute("books", books);
        return "listOfBooks";
    }
}
