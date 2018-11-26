package com.THR.DesignPatterns.代理模式.动态代理2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFly {

    private Object target;

    public ProxyFly(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("准备起飞");

                        Object returnValue = method.invoke(target, args);

                        System.out.println("已经起飞");

                        return returnValue;
                    }
                });
    }

}
