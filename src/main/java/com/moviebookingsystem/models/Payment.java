package com.moviebookingsystem.models;

import com.moviebookingsystem.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private String referenceNumber;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
