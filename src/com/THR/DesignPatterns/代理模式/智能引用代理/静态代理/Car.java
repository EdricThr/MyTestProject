package com.THR.DesignPatterns.代理模式.智能引用代理.静态代理;

import java.util.Random;

public class Car implements Moveable {

    @Override
    public void move() {

        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
