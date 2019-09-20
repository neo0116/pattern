package com.ByteDance.strategy.orderStrategy.strategy;

import com.ByteDance.strategy.orderStrategy.Order;
import com.ByteDance.strategy.orderStrategy.PayResult;

/**
 * @ClassName AliPayment
 * @Description TODO
 * @Version 1.0
 **/
public class AliPayment implements Payment {
    public String getName() {
        return "阿里支付";
    }

    public double getBalance() {
        return 10000;
    }

    public PayResult excutePay(Order order) {
        double orderPrice = order.getOrderPrice();
        return orderPrice <= getBalance() ?
                new PayResult(00, "阿里支付成功", "花费了" + orderPrice) :
                new PayResult(11, "阿里支付失败", "余额不足");
    }
}
