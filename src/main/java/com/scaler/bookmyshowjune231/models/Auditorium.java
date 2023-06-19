package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

//    @OneToMany
//    private List<Show> shows; // shows available for booking
//
//    @OneToOne
//    private Show show; // current running show
}
