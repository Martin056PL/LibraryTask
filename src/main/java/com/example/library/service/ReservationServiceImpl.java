package com.example.library.service;

import com.example.library.dao.BookRepository;
import com.example.library.dao.ReservationRepository;
import com.example.library.dao.UserRepository;
import com.example.library.domain.Book;
import com.example.library.domain.Reservation;
import com.example.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Service
public class ReservationServiceImpl implements ReservationService {

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(BookRepository bookRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void makeReservation(Long bookId, HttpServletRequest request){
        Book book = findBookByBookId(bookId);
        User user = findUserByLogin(getLoginFromCurrentSession(request));
        Reservation reservation = new Reservation(user,book, LocalDate.now(),LocalDate.now().plusMonths(1));
        reservationRepository.save(reservation);
    }

    private String getLoginFromCurrentSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (String) session.getAttribute("login");
    }

    private User findUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }

    private Book findBookByBookId(Long bookId){
        return bookRepository.findBookByBookId(bookId).get(0);
    }
}
