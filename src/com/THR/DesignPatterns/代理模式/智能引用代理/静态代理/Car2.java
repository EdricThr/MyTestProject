package com.THR.DesignPatterns.代理模式.智能引用代理.静态代理;

/**
 * 使用继承的方式实现静态代理
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("汽车行驶的时间：" + moveTime);
    }
}
