package com.example.library.controllers;

import com.example.library.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/makeReservation")
public class ReservationController {

    private ReservationServiceImpl service;

    @Autowired
    public ReservationController(ReservationServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "{bookId}",method = RequestMethod.GET)
    public String makeReservation(@PathVariable Long bookId, HttpServletRequest request){
        service.makeReservation(bookId,request);
        return "confirmationOfBookReservation";
    }
}
