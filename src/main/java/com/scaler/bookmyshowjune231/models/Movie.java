package com.scaler.bookmyshowjune.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel {
    private List<Language> languages;
}
