package com.THR.DesignPatterns.代理模式.智能引用代理.静态代理;

public class CarLogProxy implements Moveable {

    private Moveable car;

    public CarLogProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {

        System.out.println("开始记录汽车行驶日志");
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("结束记录汽车行驶日志");
    }
}
