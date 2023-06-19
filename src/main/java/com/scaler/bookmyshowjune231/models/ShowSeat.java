package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;
}
// find cardinality of reln b/w SS :S and ShowSeat and Seat
// breal till 10:30

////       "AVAIALBLE" -> 0
///        "BOOKED"    -> 2
///        "AVAILABLE" -> 0
////       "LOCKED"    -> 1