package com.THR.DesignPatterns.�н���ģʽ2;

public class Client_ZhongJieZhe2 {


    public static void main(String args[]){

        MainBoard mediator = new MainBoard();

        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard vc = new VideoCard(mediator);

        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        cd.readCD();
    }
}
