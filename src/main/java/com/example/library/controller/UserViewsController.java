package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserViewsController {

    @RequestMapping("/userOptions")
    public String userOptions() {
        return "userOptions";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping("/loginForm")
    public String loginUser() {
        return "loginForm";
    }

}
