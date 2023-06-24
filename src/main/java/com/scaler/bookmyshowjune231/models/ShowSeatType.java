package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel {
    // xyz
    @ManyToOne
    private Show show;

    // xyz
    @ManyToOne
    private SeatType seatType;
    private int price;
}
