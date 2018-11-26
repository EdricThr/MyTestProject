package com.THR.DesignPatterns.命令模式;

/**
 * Receiver -2 接收者
 */
public class TV implements HouseHoldAppliances {
    @Override public void on() {
        System.out.println("the TV on");
    }

    @Override public void off() {
        System.out.println("the TV off");
    }
}
