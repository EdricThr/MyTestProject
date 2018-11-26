package com.THR.DesignPatterns.命令模式;

/**
 * Receiver -1 接收者
 */
public class Light implements HouseHoldAppliances {
    @Override public void on() {
        System.out.println("the Light on");
    }

    @Override public void off() {
        System.out.println("the Light on");
    }
}
