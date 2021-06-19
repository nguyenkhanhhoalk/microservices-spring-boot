package com.hoank.cloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallback() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallback() {
        return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
    }
}
