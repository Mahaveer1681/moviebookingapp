package com.moviebookingsystem.service.impl;

import com.moviebookingsystem.models.Offer;
import com.moviebookingsystem.models.Seat;
import com.moviebookingsystem.models.Show;
import com.moviebookingsystem.repositories.OfferRepository;
import org.hibernate.dialect.function.TrimFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class PriceCalculatorService {

    @Autowired
    private OfferRepository offerRepository;

    public Double calculatePrice(Show bookShow, List<String> bookingSeatNumbers) {
        List<Seat> showSeats = bookShow.getScreen().getSeats();
        Stream<Seat> bookingSeats = showSeats.stream().filter(seat -> bookingSeatNumbers.contains(seat.getSeatNumber()));

        Double price = bookingSeats.mapToDouble(Seat::getPrice).sum();

        calculateDiscount(bookShow, bookingSeats, bookingSeatNumbers);

        double discount = calculateDiscount(bookShow, bookingSeats, bookingSeatNumbers);
        System.out.println("Before Discount::"+price);
        System.out.println(" discount::"+discount);
        double finalPrice=price-discount;
        System.out.println("After Discount::"+finalPrice);
        return finalPrice;
    }

    private double calculateDiscount(Show bookShow, Stream<Seat> bookingSeats, List<String> bookingSeatNumbers) {

        List<Offer> offers = offerRepository.findAllByShowShowId(bookShow.getShowId());
        List<Double> discountList = new ArrayList<>();

        double calculatedDiscount = 0;
        offers.stream().forEach(offer -> {
            String parameter = offer.getParameter();
            switch (parameter) {
                case "SEATNUMBER" -> {
                    boolean c1 = false;
                    boolean c2 = false;
                    String conditionJoiner = offer.getConditionJoiner();
                    int seatCount = bookingSeatNumbers.size();

                    if (validateSeatCountConditions(offer, seatCount)) {
                        bookingSeats.sorted(Comparator.comparing(Seat::getPrice).reversed());
                        int limit = seatCount / Integer.parseInt(offer.getCondition1());
                        //calculating discount on seats with prices
                        double minsum = bookingSeats.limit(limit).mapToDouble(Seat::getPrice).sum();

                        discountList.add(minsum * offer.getDiscount() / 100);
                    }
                }
                case "SHOWTIME" -> {
                    LocalTime bookTime = bookShow.getShowTime();
                    if (validateShowTimeConditions(offer, bookTime)) {
                        double sum = bookingSeats.mapToDouble(Seat::getPrice).sum();
                        discountList.add(sum * offer.getDiscount() / 100);
                    }
                }
                default -> discountList.add(0.00);
            }
        });
// return min discount if multiple conditions match
        return discountList.stream().sorted(Collections.reverseOrder()).findFirst().get();

    }

    private boolean validateSeatCountConditions(Offer offer, int seatCount) {
        boolean c1 = false;
        boolean c2 = false;
        String conditionJoiner = offer.getConditionJoiner();
        if ("EQUALS".equals(offer.getOperator1()))
            c1 = (seatCount == Integer.parseInt(offer.getCondition1()));
        if ("GREATERTHAN".equals(offer.getOperator2()))
            c1 = (seatCount == Integer.parseInt(offer.getCondition2()));
        return booleanConditionEval(c1, c2, conditionJoiner);
    }

    private boolean validateShowTimeConditions(Offer offer, LocalTime bookTime) {
        boolean c1 = false;
        boolean c2 = false;
        String conditionJoiner = offer.getConditionJoiner();
        if ("from".equals(offer.getOperator1()))
            c1 = bookTime.isAfter(LocalTime.parse(offer.getCondition1()));

        if ("to".equals(offer.getOperator2()))
            c2 = bookTime.isBefore(LocalTime.parse(offer.getCondition2()));

        return booleanConditionEval(c1, c2, conditionJoiner);
    }

    private boolean booleanConditionEval(boolean c1, boolean c2, String conditionJoiner) {
        return switch (conditionJoiner) {
            case "AND" -> c1 & c2;
            case "OR" -> c1 | c2;
            default -> false;
        };
    }
}