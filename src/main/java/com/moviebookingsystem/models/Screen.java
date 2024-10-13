package com.moviebookingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;
    private String name;

    @ManyToOne
    @JoinColumn(name="theatre_id")
    @JsonIgnoreProperties("screen")
    private Theatre theatre;

    @JsonIgnore
    @OneToMany(mappedBy = "screen")
    private List<Show> shows;

    @OneToMany(mappedBy = "screen")
    @JsonIgnoreProperties("screen")
    private List<Seat> seats;

}
