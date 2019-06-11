package com.example.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class User implements Serializable, UserInterface {

    private static final long serialVersionUID = 8062231146287834334L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Long phoneNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String zipCode;

    public User() {
        //constructor for hibernate
    }

    private User(String login, String password, String email, Long phoneNumber, String firstName,
                 String lastName, LocalDate dateOfBirth, String address, String city, String zipCode) {

        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static class UserBuilder {

        private String login;
        private String password;
        private String email;
        private Long phoneNumber;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String address;
        private String city;
        private String zipCode;

        public UserBuilder setUserLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setUserPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setUserEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setUserPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder setUserFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setUserLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setUserDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
            return this;
        }

        public UserBuilder setUserAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setUserCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setUserZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public User build() {
            boolean isAllFielsdAreFull = login != null && password != null && email != null
                    && phoneNumber != null && firstName != null
                    && lastName != null && dateOfBirth != null && address != null
                    && city != null && zipCode != null;

            if (isAllFielsdAreFull) {
                return new User(login, password, email, phoneNumber, firstName, lastName, dateOfBirth, address, city, zipCode);
            } else {
                throw new RuntimeException("Some fields are null!");
            }
        }

    }

}
