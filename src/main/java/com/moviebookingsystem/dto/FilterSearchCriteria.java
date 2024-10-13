package com.moviebookingsystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@Builder
public class FilterSearchCriteria {
    private String language;
    private String theatreName;
    private Date showDate;
    private LocalTime showTime;
    private Set<String> genres;

}
