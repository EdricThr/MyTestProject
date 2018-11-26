package com.THR.DesignPatterns.代理模式.智能引用代理.静态代理;

public class CarTimeProxy implements Moveable {

    private Moveable car;

    public CarTimeProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {

        System.out.println("开始记录汽车行驶的时间");
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("汽车行驶的时间：" + moveTime);
        System.out.println("结束记录汽车行驶的时间");
    }
}
