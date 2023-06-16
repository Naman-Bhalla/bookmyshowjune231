package com.scaler.bookmyshowjune231.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String seatNumber;
    private int row;
    private int col;
    private SeatType seatType;
}
