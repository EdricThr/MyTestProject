package com.THR.DesignPatterns.抽象工厂模式;

public class AmdMainboard implements Mainboard {

    private int cpuHoles = 0;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("AmdMainboard: 插槽孔：" + this.cpuHoles);
    }
}
