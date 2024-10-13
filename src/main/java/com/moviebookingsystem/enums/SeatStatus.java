package com.moviebookingsystem.enums;

public enum SeatStatus {
    BOOKED("BOOKED"),
    UNAVAILABLE("UNAVAILABLE"),
    EMPTY("EMPTY"),
    LOCKED("LOCKED");

    private final String value;
    private SeatStatus(String value) {this.value=value;}

    private String getValue() {return this.value;}
}
