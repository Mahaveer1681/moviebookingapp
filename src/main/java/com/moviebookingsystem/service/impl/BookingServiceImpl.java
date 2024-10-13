package com.moviebookingsystem.service.impl;

import com.moviebookingsystem.dto.BookingRequest;
import com.moviebookingsystem.dto.BookingResponse;
import com.moviebookingsystem.enums.BookingStatus;
import com.moviebookingsystem.enums.PaymentStatus;
import com.moviebookingsystem.enums.SeatStatus;
import com.moviebookingsystem.models.Booking;
import com.moviebookingsystem.models.Seat;
import com.moviebookingsystem.models.Show;
import com.moviebookingsystem.models.User;
import com.moviebookingsystem.repositories.BookingRepository;
import com.moviebookingsystem.repositories.ShowRepository;
import com.moviebookingsystem.repositories.SeatRepository;
import com.moviebookingsystem.repositories.UserRepository;

import com.moviebookingsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PriceCalculatorService priceCalculatorService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public BookingResponse bookTicket(BookingRequest bookingRequest) {

        Long userId = bookingRequest.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {

        }
        User user = userOptional.get();

        Show bookShow = bookingRequest.getShow();
        List<String> bookingSeatNumbers = bookingRequest.getSeatNumbers();
        List<Seat> showSeats = seatRepository.findAllByScreenIdAndSeatNumberIn(bookShow.getScreen().getScreenId(), bookingSeatNumbers);

        for (Seat seat : showSeats) {
            if (!seat.getSeatStatus().equals(SeatStatus.EMPTY)) {
                throw new RuntimeException("Seats not Available");
            }
        }
        updateSeatStatus(showSeats, SeatStatus.LOCKED);

        Booking booking = new Booking();
        Double amount = priceCalculatorService.calculatePrice(bookShow, bookingSeatNumbers);

        if (redirectToPaymentService(userId, amount, new HashMap<String, String>())) {
            booking.setPaymentStatus(PaymentStatus.SUCESS);
            updateSeatStatus(showSeats, SeatStatus.BOOKED);
        } else {
            booking.setPaymentStatus(PaymentStatus.FAILURE);
            updateSeatStatus(showSeats, SeatStatus.EMPTY);
        }


        booking.setUser(user);

       booking.setSeatNumbers(bookingSeatNumbers);
        booking.setAmount(amount);

        Booking confirmedBooking= bookingRepository.save(booking);
       return    BookingResponse.builder()
               .bookingId(confirmedBooking.getBookingId())
                .userName(user.getName())
                .bookedSeatNumbers(confirmedBooking.getSeatNumbers())
                .amount(confirmedBooking.getAmount())
                .movie(bookShow.getMovie())
                .theatreName(bookShow.getTheatre().getName())
                .screenName(bookShow.getScreen().getName())
                .bookingStatus(BookingStatus.CONFIRMED)
                .paymentStatus(confirmedBooking.getPaymentStatus())
                .build();


    }

    private void updateSeatStatus(List<Seat> showSeats, SeatStatus status) {
        showSeats.stream().forEach(seat -> seat.setSeatStatus(status));
        seatRepository.saveAll(showSeats);
    }

    private boolean redirectToPaymentService(Long userId, Double amount, Map<String, String> otherParameters) {
        return true;
    }
}
