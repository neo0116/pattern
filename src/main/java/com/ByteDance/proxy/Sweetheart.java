package com.ByteDance.proxy;

import java.lang.reflect.Method;

/**
 * @ClassName Sweetheart
 * @Description TODO
 * @Version 1.0
 **/
public class Sweetheart implements BDInvocationHandler{

    private Object marvel;

    public Object getInstance(Object marvel) {
        this.marvel = marvel;
        Class clazz = marvel.getClass();
        return BDProxy.newProxyInstance(new BDClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invokeResult = method.invoke(this.marvel, args);
        after();
        return invokeResult;
    }

    private void before() {
        System.out.println("帮钢铁侠穿衣");
    }

    private void after() {
        System.out.println("帮钢铁侠脱衣");
    }

}
