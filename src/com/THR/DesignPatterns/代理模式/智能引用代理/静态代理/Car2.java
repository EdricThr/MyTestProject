package com.THR.DesignPatterns.����ģʽ.�������ô���.��̬����;

/**
 * ʹ�ü̳еķ�ʽʵ�־�̬����
 */
public class Car2 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("������ʻ��ʱ�䣺" + moveTime);
    }
}
