package com.hoank.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_TB")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;

}
