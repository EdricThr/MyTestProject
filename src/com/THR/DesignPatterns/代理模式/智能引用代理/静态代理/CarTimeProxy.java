package com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����;

public class CarTimeProxy implements Moveable {

    private Moveable car;

    public CarTimeProxy(Moveable car) {
        this.car = car;
    }

    @Override
    public void move() {

        System.out.println("��ʼ��¼������ʻ��ʱ��");
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("������ʻ��ʱ�䣺" + moveTime);
        System.out.println("������¼������ʻ��ʱ��");
    }
}
