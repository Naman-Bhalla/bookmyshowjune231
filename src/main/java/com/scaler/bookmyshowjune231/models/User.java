package com.scaler.bookmyshowjune.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private int age;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
