package com.moviebookingsystem.controllers;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.moviebookingsystem.dto.FilterSearchCriteria;
import com.moviebookingsystem.models.Show;
import com.moviebookingsystem.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Show>> getAllShows(
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String theatreName,
            @RequestParam(required = false) Date showDate,
            @RequestParam(required = false) LocalTime showTime,
            @RequestParam(name = "genres", required = false)
            Set<String> genres
    ) {
        FilterSearchCriteria searchCriteria = FilterSearchCriteria.builder()
                .language(language)
                .theatreName(theatreName)
                .showDate(showDate)
                .showTime(showTime)
                .genres(genres)
                .build();
        return ResponseEntity.ok(showService.getAllShows(searchCriteria));
    }
    
}
