package com.hoank.payment.controller;

import com.hoank.payment.entity.Payment;
import com.hoank.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@Slf4j
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public Payment doPayment(@RequestBody Payment payment){
        log.info("Inside method doPayment of PaymentController");
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable("orderId") int orderId){
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }


}
