package com.example.library.service;

import com.example.library.domain.User;

public interface UserService {

    void saveUser(User user);

    boolean validateUserData(User user);

    boolean isDataAvailable(User user);

    boolean areLoginDataCorrect(String login, String password);
}
