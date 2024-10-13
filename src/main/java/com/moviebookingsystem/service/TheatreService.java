package com.moviebookingsystem.service;

import com.moviebookingsystem.models.Theatre;

import java.util.List;

public interface TheatreService {
    Theatre addTheatre(Theatre theatre);

    void removeTheatre(long id);

    List<Theatre> getAllTheatresFromCity(String cityName);
}
