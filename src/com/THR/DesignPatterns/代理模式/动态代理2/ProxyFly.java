package com.THR.DesignPatterns.����ģʽ.��̬����2;

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

                        System.out.println("׼�����");

                        Object returnValue = method.invoke(target, args);

                        System.out.println("�Ѿ����");

                        return returnValue;
                    }
                });
    }

}
