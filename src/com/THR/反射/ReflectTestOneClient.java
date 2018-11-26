package com.THR.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 用于反射的基本使用测试
 * 摘自精通Spring4.x p78
 */
public class ReflectTestOneClient {

    public static void main(String args[]) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.反射.Car");

        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car) constructor.newInstance();

        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(car, "奔驰");
        System.out.println(car);
    }
}
