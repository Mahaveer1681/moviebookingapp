package com.moviebookingsystem.models;


import com.moviebookingsystem.enums.Genre;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity(name="movies")
public class Movie{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long movieId;
    private String name;
    private String language;


    @Enumerated(EnumType.STRING)
    private List<Genre> genre;

}
