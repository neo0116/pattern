package com.ByteDance.strategy.orderStrategy;

/**
 * @ClassName Order
 * @Description TODO
 * @Version 1.0
 **/
public class Order {

    private String orderCode;

    private double orderPrice;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
