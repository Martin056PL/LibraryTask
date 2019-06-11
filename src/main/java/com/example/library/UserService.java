package com.example.library;

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

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        User user = new User.UserBuilder()
                .setUserLogin("sadfSADFSDF23RSADSAd")
                .setUserPassword("Mareczek3@")
                .setUserEmail("mareczek@gmail.com")
                .setUserPhoneNumber(515791468L)
                .setUserFirstName("Marek")
                .setUserLastName("Kowalski")
                .setUserDateOfBirth("1990-12-12")
                .setUserAddress("Kowalska 12")
                .setUserCity("Lublin")
                .setUserZipCode("20-123")
                .build();

        userRepo.save(user);

    }
}
