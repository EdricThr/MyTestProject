package com.THR.DesignPatterns.抽象工厂模式;

public class AmdCpu implements  Cpu {

    private int pins = 0;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("AmdCpu:针脚数：" + pins);
    }
}
