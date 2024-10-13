package com.moviebookingsystem.service;

import com.moviebookingsystem.dto.BookingRequest;
import com.moviebookingsystem.dto.BookingResponse;

import java.util.List;

public interface BookingService {
    public BookingResponse bookTicket(BookingRequest bookingRequest);
}
