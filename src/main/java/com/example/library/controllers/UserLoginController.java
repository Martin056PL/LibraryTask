package com.example.library.controllers;

import com.example.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    private UserServiceImpl service;

    @Autowired
    private UserLoginController(UserServiceImpl service) {
        this.service = service;}

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(Model model
            , @RequestParam(value = "login") String login
            , @RequestParam(value = "password") String password
            , HttpServletRequest request) {

        boolean areLoginDataCorrect = service.areLoginDataCorrect(login, password);

        if (areLoginDataCorrect) {
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
            return "loginPage";
        } else {
            model.addAttribute("IncorrectData", true);
            return "loginForm";
        }
    }

    @RequestMapping("/logout")
    public String showLogOutPage(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "index";
    }

}
