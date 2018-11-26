package com.THR.DesignPatterns.���󹤳�ģʽ;

public class IntelMainboard implements Mainboard {

    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("IntelMainboard: ��ۿף�" + this.cpuHoles);
    }
}
