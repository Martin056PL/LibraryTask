package com.example.library.service;

import javax.servlet.http.HttpServletRequest;

public interface ReservationService {

    void makeReservation(Long bookId, HttpServletRequest request);

}
