package com.moviebookingsystem.service;

import com.moviebookingsystem.dto.FilterSearchCriteria;
import com.moviebookingsystem.models.Show;
import java.util.List;
public interface ShowService {
 public List<Show> getAllShows( FilterSearchCriteria searchCriteria);
}
