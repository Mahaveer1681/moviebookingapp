package com.moviebookingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name="city_id")
    @JsonIgnoreProperties("theatre")
    private City city;

    @OneToMany(mappedBy = "theatre")
    @JsonIgnore
    private List<Screen> screens;

}
