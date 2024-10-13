package com.moviebookingsystem.service.impl;

import com.moviebookingsystem.models.Seat;
import com.moviebookingsystem.models.Show;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PriceCalculatorService {

    public Double calculatePrice(Show bookShow, List<String> bookingSeatNumbers) {
        List<Seat> showSeats = bookShow.getScreen().getSeats();
        Double price = showSeats.stream().filter(seat -> bookingSeatNumbers.contains(seat.getSeatNumber()))
                .mapToDouble(Seat::getPrice).sum();

        //price=price-calculateDisount();
        return price;
    }
}
