package com.THR.����;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ���ڷ���Ļ���ʹ�ò���
 * ժ�Ծ�ͨSpring4.x p78
 */
public class ReflectTestOneClient {

    public static void main(String args[]) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.����.Car");

        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car) constructor.newInstance();

        Method setBrand = clazz.getDeclaredMethod("setBrand", String.class);
        setBrand.invoke(car, "����");
        System.out.println(car);
    }
}
