package com.THR.DesignPatterns.���󹤳�ģʽ;

public class AbstraceClient {

    public static void main(String args[]){
        AbstractFactory intelFactory = new IntelFactory();
        Cpu intelCpu = intelFactory.createCpu();
        Mainboard intelMainboard = intelFactory.createMainboard();
        intelCpu.calculate();
        intelMainboard.installCpu();
    }
}
