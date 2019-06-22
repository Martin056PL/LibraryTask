package com.example.library.controller;


import com.example.library.dao.UserRepository;
import com.example.library.dao.UserService;
import com.example.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserRegistrationController {

    private UserRepository repository;
    private UserService service;

    @Autowired
    private UserRegistrationController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String saveNewUser(Model model
            , @RequestParam(value = "login") String login
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "email") String email
            , @RequestParam(value = "firstName") String firstName
            , @RequestParam(value = "lastName") String lastName
            , @RequestParam(value = "phoneNumber") Long phoneNumber
            , @RequestParam(value = "dateOfBirth") String dateOfBirth
            , @RequestParam(value = "address") String address
            , @RequestParam(value = "city") String city
            , @RequestParam(value = "zipCode") String zipCode) {

        User user = createUser(login, password, email, firstName, lastName, phoneNumber, dateOfBirth, address, city, zipCode);

        boolean areRegistrationDataCorrect = service.validateUserData(user);
        boolean areRegistrationDataAvailable = service.isDataAvailable(user);

        if (areRegistrationDataCorrect && areRegistrationDataAvailable) {
            service.saveUser(user);
            return "userSave";
        } else {
            model.addAttribute("IncorrectData", true);
            return "addUser";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(Model model
            , @RequestParam(value = "login") String login
            , @RequestParam(value = "password") String password
            , HttpServletRequest request) {

        boolean areLoginDataCorrect = service.areLoginDataCorrect(login, password);

        if (areLoginDataCorrect) {
            request.getSession();
            return "loginPage";
        } else {
            model.addAttribute("IncorrectData", true);
            return "loginForm";
        }
    }


    private User createUser(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("phoneNumber") Long phoneNumber, @RequestParam("dateOfBirth") String dateOfBirth, @RequestParam("address") String address, @RequestParam("city") String city, @RequestParam("zipCode") String zipCode) {
        return new User.UserBuilder()
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
    }
}
