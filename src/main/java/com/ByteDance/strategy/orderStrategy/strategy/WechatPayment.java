package com.ByteDance.strategy.orderStrategy.strategy;

import com.ByteDance.strategy.orderStrategy.Order;
import com.ByteDance.strategy.orderStrategy.PayResult;

/**
 * @ClassName WechatPayment
 * @Description TODO
 * @Version 1.0
 **/
public class WechatPayment implements Payment {
    public String getName() {
        return "微信支付";
    }

    public double getBalance() {
        return 5000;
    }

    public PayResult excutePay(Order order) {
        double orderPrice = order.getOrderPrice();
        return orderPrice <= getBalance() ?
                new PayResult(00, "微信支付成功", "花费了" + orderPrice) :
                new PayResult(11, "微信支付失败", "余额不足");
    }
}
