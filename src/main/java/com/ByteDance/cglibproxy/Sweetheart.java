package com.ByteDance.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName Sweetheart
 * @Description TODO 代理类
 * @Version 1.0
 **/
public class Sweetheart implements MethodInterceptor {

    //底层通过继承实现
    public Object getInstance(Class<?> targetProxy) {
        //Enhancer相当于Proxy工具
        Enhancer enhancer = new Enhancer();
        //把被代理类设置成父类
        enhancer.setSuperclass(targetProxy);
        //回调下面的intercept();
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //方法增强
        before();
        Object o1 = methodProxy.invokeSuper(o, objects);
        after();
        return o1;
    }

    private void before() {
        System.out.println("上班帮boss整理文件，端茶倒水");
    }

    private void after() {
        System.out.println("下班帮boss关门");
    }
}
