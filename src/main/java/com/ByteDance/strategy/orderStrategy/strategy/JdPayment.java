package com.ByteDance.strategy.orderStrategy.strategy;

import com.ByteDance.strategy.orderStrategy.Order;
import com.ByteDance.strategy.orderStrategy.PayResult;

/**
 * @ClassName JdPayment
 * @Description TODO
 * @Version 1.0
 **/
public class JdPayment implements Payment {
    public String getName() {
        return "京东支付";
    }

    public double getBalance() {
        return 8000;
    }

    public PayResult excutePay(Order order) {
        double orderPrice = order.getOrderPrice();
        return orderPrice <= getBalance() ?
                new PayResult(00, "京东支付成功", "花费了" + orderPrice) :
                new PayResult(11, "京东支付失败", "余额不足");
    }
}
