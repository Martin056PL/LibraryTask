package com.example.library.controllers;

import com.example.library.service.BookServiceImpl;
import com.example.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class BookSearchingController {

    private BookServiceImpl service;

    @Autowired
    public BookSearchingController(BookServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/getAll")
    public String returnFullListOfBooks(Model model) {
        List<Book> books = service.returnFullListOfBooks();
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/getAllAvailable")
    public String returnFullListAvailableBooks(Model model) {
        List<Book> books = service.findAllByIsAvailableTrue();
        model.addAttribute("books", books);
        return "listOfBooks";
    }

    @RequestMapping("/getBookByBookId")
    public String returnBookByBookId(Model model, @RequestParam(value = "bookId") String bookId) {
        try {
            List<Book> books = service.findBookByBookId(Long.parseLong(bookId));
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByTitle")
    public String returnBookByTitle(Model model, @RequestParam(value = "bookTitle") String title) {
        try {
            List<Book> books = service.findBookByTitle(title);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByAuthor")
    public String returnBookByAuthor(Model model, @RequestParam(value = "bookAuthor") String author) {
        try {
            List<Book> books = service.findBookByAuthor(author);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByIsbn")
    public String returnBookByISBN(Model model, @RequestParam(value = "bookIsbn") String isbn) {
        try {
            List<Book> books = service.findBookByISBN(isbn);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByPublishingHouse")
    public String returnBookByPublishingHouse(Model model, @RequestParam(value = "bookPublishingHouse") String publishingHouse) {
        try {
            List<Book> books = service.findBookByPublishingHouse(publishingHouse);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByPlaceOfDeploy")
    public String returnBookByPlaceOfDeploy(Model model, @RequestParam(value = "bookByPlaceOfDeploy") String placeOfDeploy) {
        try {
            List<Book> books = service.findBookByPlaceOfDeploy(placeOfDeploy);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
        return "listOfBooks";
    }

    @RequestMapping("/getBookByPrice")
    public String returnBookByPrice(Model model, @RequestParam(value = "bookByPrice")String price) {
        try {
            BigDecimal priceFromStringToBigDecimalWithLongConversion = BigDecimal.valueOf(Long.parseLong(price));
            List<Book> books = service.findBookByPrice(priceFromStringToBigDecimalWithLongConversion);
            model.addAttribute("books", books);
        } catch (IllegalArgumentException e) {
            return "noSuchBook";
        }
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
