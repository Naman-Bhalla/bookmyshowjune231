package com.scaler.bookmyshowjune231.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel {
    private int amount;
    private Date timeOfBookng;
    private List<Seat> seats;
    private User bookedBy;
    private Show show;
    private List<Payment> payments;
    private TicketStatus status;
}
