package com.moviebookingsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @ManyToOne
    @JoinColumn(name="show_id")
    private Show show;
//    @ManyToOne
//    @JoinColumn(name="movie_id")
//    private Movie movie;
//
//    @ManyToOne
//    @JoinColumn(name="movie_id")
//    private Theatre theatre;

    private String parameter;
    private Double discount;
    private String operator1;
    private String condition1;
    private String conditionJoiner;
    private String operator2;
    private String condition2;
}
