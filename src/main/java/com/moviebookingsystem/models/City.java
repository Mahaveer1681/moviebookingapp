package com.moviebookingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(unique=true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;

}
