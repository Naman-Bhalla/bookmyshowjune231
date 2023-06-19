package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import javax.xml.crypto.Data;
import java.util.Date;

@MappedSuperclass // Don't create a sep table, instead put its attributes to every child
public class BaseModel {
    @Id
    private long id;

    private Date createdDate;

    private Date lastModifiedAt;
}
