package com.THR.DesignPatterns.代理模式.智能引用代理.动态代理.Jdk动态代理;


import com.THR.DesignPatterns.代理模式.智能引用代理.静态代理.Car;
import com.THR.DesignPatterns.代理模式.智能引用代理.静态代理.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * java编程思想p339页，有动态代理的例子
 */
public class TestJdkProxy {

    public static void main(String args[]){
        Car car = new Car();
        Class<?> cls = car.getClass();
        InvocationHandler ih = new TimerHandler(car);
        /**
         * loader 类加载器
         * interfaces 实现接口
         * h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ih );
        m.move();

    }
}
