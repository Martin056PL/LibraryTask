package com.example.demo.domain;

import java.time.LocalDate;

public interface UserInterface {

    String getLogin();

    String getPassword();

    String getEmail();

    Long getPhoneNumber();

    String getFirstName();

    String getLastName();

    LocalDate getDateOfBirth();

    String getAddress();

    String getCity();

    String getZipCode();
}
