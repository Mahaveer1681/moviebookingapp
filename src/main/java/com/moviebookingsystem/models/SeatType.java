package com.moviebookingsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="seat_types")
public class SeatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatTypeId;

    private String type;
}
