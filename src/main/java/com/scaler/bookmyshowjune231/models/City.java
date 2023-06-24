package com.scaler.bookmyshowjune231.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    @OneToMany(mappedBy = "cityzzzzzzzzz") // name of the attribute in the other class that is rep the relation
    private List<Theatre> theatres;
    private String name;
}

// Break till 10:49