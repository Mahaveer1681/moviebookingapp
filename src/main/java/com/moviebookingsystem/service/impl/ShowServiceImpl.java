package com.moviebookingsystem.service.impl;

import com.moviebookingsystem.dto.FilterSearchCriteria;
import com.moviebookingsystem.models.Show;
import com.moviebookingsystem.repositories.ShowRepository;
import com.moviebookingsystem.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Override
    public List<Show> getAllShows( FilterSearchCriteria searchCriteria) {

return showRepository.getAllShows(searchCriteria);
    }
}
