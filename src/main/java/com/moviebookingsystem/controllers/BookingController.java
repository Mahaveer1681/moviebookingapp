package com.moviebookingsystem.controllers;

import com.moviebookingsystem.dto.BookingRequest;
import com.moviebookingsystem.dto.BookingResponse;
import com.moviebookingsystem.models.Booking;
import com.moviebookingsystem.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
public class BookingController {
    @Autowired
    private BookingServiceImpl bookingService;

@PostMapping(value="/book",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingResponse> bookTicket(@RequestBody BookingRequest bookingRequest) {
      return ResponseEntity.ok(bookingService.bookTicket(bookingRequest));
    }


}
