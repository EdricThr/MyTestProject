package com.THR.DesignPatterns.����ģʽ;

/**
 * Receiver -2 ������
 */
public class TV implements HouseHoldAppliances {
    @Override public void on() {
        System.out.println("the TV on");
    }

    @Override public void off() {
        System.out.println("the TV off");
    }
}
