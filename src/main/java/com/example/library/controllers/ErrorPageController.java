package com.example.library.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping("/error")
    public String showErrorPage(){
        return "error404";
    }

    @RequestMapping("/index")
    public String showMainPage(){
        return "index";
    }


}
