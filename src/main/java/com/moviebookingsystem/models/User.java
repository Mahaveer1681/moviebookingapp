package com.moviebookingsystem.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String contact;
    private String password;

    @OneToMany
    private List<Booking> bookings;
}
