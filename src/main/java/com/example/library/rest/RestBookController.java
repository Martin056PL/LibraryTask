package com.example.library.rest;

import com.example.library.domain.Book;
import com.example.library.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/rest")
public class RestBookController {

    private BookServiceImpl service;

    @Autowired
    public RestBookController(BookServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/get-all-books")
    public List<Book> getAllBooks() {
        return service.returnFullListOfBooks();
    }

    @GetMapping("/get-book-by-id")
    public List<Book> getBookById(@RequestParam Long id) {
        return service.findBookByBookId(id);
    }

    @PostMapping("/add-new-book")
    public Boolean addBookToRepository(@RequestBody Book book) {
        service.addBook(book);
        return true;
    }

    @DeleteMapping("/delete-book-by-id")
    @Transactional
    public Boolean deleteBookFromRepositoryById(@RequestParam Long id) {
        service.deleteBook(id);
        return true;
    }
}
