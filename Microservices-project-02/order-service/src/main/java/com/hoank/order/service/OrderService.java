package com.hoank.order.service;

import com.hoank.order.VO.PaymentVO;
import com.hoank.order.VO.TransactionRequest;
import com.hoank.order.VO.TransactionResponse;
import com.hoank.order.entity.Order;
import com.hoank.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public TransactionResponse saveOrder(TransactionRequest request){
        Order order = orderRepository.save(request.getOrder());
        PaymentVO payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        PaymentVO paymentResponse = restTemplate.postForObject(ENDPOINT_URL, payment, PaymentVO.class);
        String message = "";
        message = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successfull and order placed" : " there is failure in payment api, order added to cart";

        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), message);
    }
}
