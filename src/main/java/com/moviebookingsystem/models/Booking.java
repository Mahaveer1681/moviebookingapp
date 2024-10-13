package com.moviebookingsystem.models;

import com.moviebookingsystem.enums.BookingStatus;
import com.moviebookingsystem.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private Double amount;

    private List<String> seatNumbers;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Date bookedAt;
}
