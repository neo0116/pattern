package com.ByteDance.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName Sweetheart
 * @Description TODO  钢铁侠的小甜心
 * @Version 1.0
 **/
public class Sweetheart{

    private Object marvel;

    public Marvel getInstance(Marvel marvel) {
        this.marvel = marvel;
        Class<? extends Marvel> clazz = marvel.getClass();
        return (Marvel) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();
                Object invokeResult = method.invoke(marvel, args);
                after();
                return invokeResult;
            }
        });
    }

    private void before() {
        System.out.println("帮钢铁侠穿衣");
    }

    private void after() {
        System.out.println("帮钢铁侠脱衣");
    }

}
