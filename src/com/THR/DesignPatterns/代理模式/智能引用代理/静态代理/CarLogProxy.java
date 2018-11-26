package com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����;

public class CarLogProxy implements Moveable {

    private Moveable car;

    public CarLogProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {

        System.out.println("��ʼ��¼������ʻ��־");
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("������¼������ʻ��־");
    }
}
