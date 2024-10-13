package com.moviebookingsystem.dto;

import com.moviebookingsystem.enums.BookingStatus;
import com.moviebookingsystem.enums.PaymentStatus;
import com.moviebookingsystem.enums.ResponseStatus;
import com.moviebookingsystem.models.Movie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookingResponse {
    private Long bookingId;
    private String userName;

    private double amount;
    private String theatreName;
    private String screenName;
    private Movie movie;
    private List<String> bookedSeatNumbers;
    private BookingStatus bookingStatus;
    private PaymentStatus paymentStatus;

}
