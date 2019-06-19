package com.example.library.controller;


import com.example.library.dao.UserRepository;
import com.example.library.domain.Book;
import com.example.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class UserRegistrationController {

    private UserRepository repository;

    @Autowired
    public UserRegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String saveNewUser(Model model
    ,@RequestParam(value = "login") String login
    ,@RequestParam(value = "password") String password
    ,@RequestParam(value = "email") String email
    ,@RequestParam(value = "firstName") String firstName
    ,@RequestParam(value = "lastName") String lastName
    ,@RequestParam(value = "phoneNumber") Long phoneNumber
    ,@RequestParam(value = "dateOfBirth") String dateOfBirth
    ,@RequestParam(value = "address") String address
    ,@RequestParam(value = "city") String city
    ,@RequestParam(value = "zipCode") String zipCode) {

        User user = new User.UserBuilder()
                .setUserLogin(login)
                .setUserPassword(password)
                .setUserEmail(email)
                .setUserPhoneNumber(phoneNumber)
                .setUserFirstName(firstName)
                .setUserLastName(lastName)
                .setUserDateOfBirth(dateOfBirth)
                .setUserAddress(address)
                .setUserCity(city)
                .setUserZipCode(zipCode)
                .build();

        repository.save(user);

        return "userSave";
    }

}
