package com.scaler.bookmyshowjune.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel {
    private int amount;
    private PaymentProvider paymentProvider;
    private Date time;
    private String refId;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
