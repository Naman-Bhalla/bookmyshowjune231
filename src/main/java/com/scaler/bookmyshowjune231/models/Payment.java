package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    private Date time;
    private String refId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @ManyToOne
    private Ticket ticket;
}
