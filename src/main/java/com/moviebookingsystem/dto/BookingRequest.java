package com.moviebookingsystem.dto;

import com.moviebookingsystem.models.Show;
import lombok.Data;

import java.util.List;

@Data
public class BookingRequest {
    private Long userId;
    private Show show;
    private List<String> seatNumbers;
}
