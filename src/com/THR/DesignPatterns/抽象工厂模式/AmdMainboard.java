package com.THR.DesignPatterns.���󹤳�ģʽ;

public class AmdMainboard implements Mainboard {

    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("AmdMainboard: ��ۿף�" + this.cpuHoles);
    }
}
