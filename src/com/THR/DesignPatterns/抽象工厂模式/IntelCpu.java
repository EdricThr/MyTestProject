package com.THR.DesignPatterns.抽象工厂模式;

public class IntelCpu implements  Cpu {

    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("IntelCpu:针脚数：" + pins);
    }
}
