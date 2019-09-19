package com.ByteDance.proxy.bdproxy;

import java.lang.reflect.Method;

/**
 * @Description //TODO  自定义的InvocationHandler
 **/
public interface BDInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
