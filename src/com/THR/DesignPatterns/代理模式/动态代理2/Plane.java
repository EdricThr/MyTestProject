package com.THR.DesignPatterns.代理模式.动态代理2;

public class Plane implements Flayable {
    @Override
    public void fly() {
        System.out.println("我是灰机，我在飞~~~~");
    }
}
