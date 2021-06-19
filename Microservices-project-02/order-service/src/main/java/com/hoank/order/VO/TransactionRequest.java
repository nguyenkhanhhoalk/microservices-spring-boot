package com.hoank.order.VO;

import com.hoank.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private Order order;
    private PaymentVO payment;

}
