package com.THR.DesignPatterns.���󹤳�ģʽ;

public class IntelCpu implements  Cpu {

    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("IntelCpu:�������" + pins);
    }
}
