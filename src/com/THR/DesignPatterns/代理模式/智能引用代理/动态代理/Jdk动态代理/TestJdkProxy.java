package com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����.Jdk��̬����;


import com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����.Car;
import com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * java���˼��p339ҳ���ж�̬���������
 */
public class TestJdkProxy {

    public static void main(String args[]){
        Car car = new Car();
        Class<?> cls = car.getClass();
        InvocationHandler ih = new TimerHandler(car);
        /**
         * loader �������
         * interfaces ʵ�ֽӿ�
         * h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ih );
        m.move();

    }
}
