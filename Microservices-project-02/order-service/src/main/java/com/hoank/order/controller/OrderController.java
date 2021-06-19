package com.hoank.order.controller;

import com.hoank.order.VO.PaymentVO;
import com.hoank.order.VO.TransactionRequest;
import com.hoank.order.VO.TransactionResponse;
import com.hoank.order.entity.Order;
import com.hoank.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public TransactionResponse saveOrder(@RequestBody TransactionRequest request){
        log.info("inside method saveOrder of OrderController");
        return orderService.saveOrder(request);
    }

}
