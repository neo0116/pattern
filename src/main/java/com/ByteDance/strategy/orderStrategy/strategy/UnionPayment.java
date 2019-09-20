package com.ByteDance.strategy.orderStrategy.strategy;

import com.ByteDance.strategy.orderStrategy.Order;
import com.ByteDance.strategy.orderStrategy.PayResult;

/**
 * @ClassName UnionPayment
 * @Description TODO
 * @Version 1.0
 **/
public class UnionPayment implements Payment {
    public String getName() {
        return "银联支付";
    }

    public double getBalance() {
        return 20000;
    }

    public PayResult excutePay(Order order) {
        double orderPrice = order.getOrderPrice();
        return orderPrice <= getBalance() ?
                new PayResult(00, "银联支付成功", "花费了" + orderPrice) :
                new PayResult(11, "银联支付失败", "余额不足");
    }
}
