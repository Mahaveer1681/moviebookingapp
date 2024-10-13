package com.moviebookingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moviebookingsystem.enums.ShowStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
@Entity(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="theatre_id")
    @JsonIgnoreProperties({"screen","city"})
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name="city_id")
    @JsonIgnoreProperties("theatre")
    private City city;

    @ManyToOne
    @JoinColumn(name="screen_id")
    @JsonIgnoreProperties({"shows","theatre"})
    private Screen screen;

    private Date startDate;
    private Date endDate;
    private LocalTime showTime;

    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;
}
