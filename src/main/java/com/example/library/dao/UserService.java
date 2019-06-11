package com.example.library.dao;

import com.example.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;


@Controller
public class UserService {


    private UserRepository userRepo;

    @Autowired
    UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //@EventListener(ApplicationReadyEvent.class)
    public void addUser(/*Some user will be added as parameter*/) {
        User user = new User.UserBuilder()
                .setUserLogin("1")
                .setUserPassword("2")
                .setUserEmail("3")
                .setUserPhoneNumber(515791468L)
                .setUserFirstName("4")
                .setUserLastName("K5i")
                .setUserDateOfBirth("1990-12-12")
                .setUserAddress("K7")
                .setUserCity("L8")
                .setUserZipCode("29")
                .build();

        System.out.println(user);
        userRepo.save(user);
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }

}
