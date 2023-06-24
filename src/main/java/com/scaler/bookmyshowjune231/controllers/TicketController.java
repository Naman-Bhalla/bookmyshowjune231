package com.scaler.bookmyshowjune231.controllers;

import com.scaler.bookmyshowjune231.dtos.BookTicketResponseDto;
import com.scaler.bookmyshowjune231.dtos.BookicketRequestDto;
import com.scaler.bookmyshowjune231.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Controller
public class TicketController {

   private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();

//        try {
////            ticketService.bookTicket()
//        } catch (TimeoutException e) {
//            response.setStatus("FAILURE");
//            response.setMessage("Something is wrong");
//        }

        return null;
    }
}
