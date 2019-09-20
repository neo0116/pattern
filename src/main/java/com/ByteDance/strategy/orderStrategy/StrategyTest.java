package com.ByteDance.strategy.orderStrategy;

import com.ByteDance.strategy.orderStrategy.strategy.Payment;
import com.ByteDance.strategy.orderStrategy.strategy.PaymentStrategy;

/**
 * @ClassName StrategyTest
 * @Description TODO
 * @Version 1.0
 **/
public class StrategyTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setOrderCode("20190919100023654");
        order.setOrderPrice(750.0);

        String payKey = "AliPay";

        Payment payment = PaymentStrategy.getCurrentPayment(payKey);

        System.out.println(payment.getName());

        System.out.println(payment.excutePay(order));
    }
}
