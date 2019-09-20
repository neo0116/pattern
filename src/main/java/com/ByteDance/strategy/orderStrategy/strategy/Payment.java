package com.ByteDance.strategy.orderStrategy.strategy;

import com.ByteDance.strategy.orderStrategy.Order;
import com.ByteDance.strategy.orderStrategy.PayResult;

public interface Payment {

    String getName();

    double getBalance();

    PayResult excutePay(Order order);

}
