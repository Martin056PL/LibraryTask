package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookViewsController {

    @RequestMapping("/bookSearcher")
    public String defectDetails() {
        return "bookSearcher";
    }

}
