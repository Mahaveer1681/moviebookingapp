package com.moviebookingsystem.models;

import com.moviebookingsystem.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    private String seatNumber;
    private int price;

    @ManyToOne
    @JoinColumn(name="screen_id")
    private Screen screen;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
