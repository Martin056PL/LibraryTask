package com.example.library.utils;

import com.example.library.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserDataValidators {

    public boolean validateUserData(User user) {
        String password = user.getPassword();
        String email = user.getEmail();
        LocalDate dateOfBirth = user.getDateOfBirth();
        return validateUsersPassword(password) && validateUsersEmail(email)&&validateUsersAge(dateOfBirth);
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
        boolean result  = compare > 0;
        return result;
    }

}
