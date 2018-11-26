package com.THR.DesignPatterns.抽象工厂模式;

public class IntelMainboard implements Mainboard {

    private int cpuHoles = 0;

    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("IntelMainboard: 插槽孔：" + this.cpuHoles);
    }
}
