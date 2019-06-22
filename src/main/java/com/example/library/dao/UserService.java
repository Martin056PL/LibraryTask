package com.example.library.dao;

import com.example.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;


@Controller
public class UserService {


    private UserRepository repository;

    @Autowired
    private UserService(UserRepository repository) {
        this.repository = repository;
    }

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
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public boolean validateUserData(User user) {
        String password = user.getPassword();
        String email = user.getEmail();
        LocalDate dateOfBirth = user.getDateOfBirth();
        return validateUsersPassword(password) && validateUsersEmail(email)&&validateUsersAge(dateOfBirth);
    }

    public boolean isDataAvailable(User user){
        String login = user.getLogin();
        String email = user.getEmail();
        boolean isEmailOk = repository.existsByEmail(email);
        boolean isLoginOk = repository.existsByLogin(login);
        return isEmailOk && isLoginOk;
    }

    private boolean validateUsersPassword(String password) {

        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}])(?=\\S+$).{8,}$";
        return password.matches(passwordPattern);

        /*^                 # start-of-string
        (?=.*[0-9])       # a digit must occur at least once
        (?=.*[a-z])       # a lower case letter must occur at least once
        (?=.*[A-Z])       # an upper case letter must occur at least once
        (?=.*[\\p{Punct}])  # a special character must occur at least once, one of: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
        (?=\S+$)          # no whitespace allowed in the entire string
        .{8,}             # anything, at least eight places though
        $                 # end-of-string
        */
    }

    private boolean validateUsersEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return email.matches(emailPattern);
    }

    private boolean validateUsersAge(LocalDate dateOfBirth) {
        LocalDate now = LocalDate.now();
        int compare = now.compareTo(dateOfBirth.plusYears(18));
        return compare > 0;
    }
}
