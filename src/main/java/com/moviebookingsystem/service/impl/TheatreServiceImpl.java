package com.moviebookingsystem.service.impl;

import com.moviebookingsystem.models.Theatre;
import com.moviebookingsystem.repositories.TheatreRepository;
import com.moviebookingsystem.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public void removeTheatre(long id) {
         theatreRepository.deleteById(id);
    }

    @Override
    public List<Theatre> getAllTheatresFromCity(String cityName) {
        return null;
       // return theatreRepository.findAllByCityName(cityName);
    }
}
