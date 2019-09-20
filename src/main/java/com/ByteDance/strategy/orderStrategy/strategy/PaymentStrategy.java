package com.ByteDance.strategy.orderStrategy.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PaymentStrategy
 * @Description TODO  策略类  （web中可以用@PostConstruct + init()方法 初始化这个payStrategy）
 * @Version 1.0
 **/
public class PaymentStrategy {

    public static final String Ali_PAY = "AliPay";

    public static final String WeChat_PAY = "WeChatPay";

    public static final String Union_PAY = "UnionPay";

    public static final String Jd_PAY = "JdPay";

    public static final String Default_PAY = Ali_PAY;

    public static final Map<String, Payment> payStrategy = new HashMap<>(16);

    static {
        payStrategy.put(Ali_PAY, new AliPayment());
        payStrategy.put(WeChat_PAY, new WechatPayment());
        payStrategy.put(Union_PAY, new UnionPayment());
        payStrategy.put(Jd_PAY, new JdPayment());
    }

    public static Payment getCurrentPayment() {
        return payStrategy.get(Default_PAY);
    }

    public static Payment getCurrentPayment(String payKey) {
        boolean hasKey = payStrategy.containsKey(payKey);
        if (!hasKey) {
            return getCurrentPayment();
        }
        return payStrategy.get(payKey);
    }

}
