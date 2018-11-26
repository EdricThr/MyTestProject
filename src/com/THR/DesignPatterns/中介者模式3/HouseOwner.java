package com.THR.DesignPatterns.中介者模式3;

public class HouseOwner extends ZPerson {


    private String complay;

    public HouseOwner(Mediator mediator) {
        super(mediator);
    }

    public void setComplay(String complay) {
        this.complay = complay;
    }

    public void speak() {
        System.out.println("回复" + complay + " : 我有房源，请打我带你话");
    }
}
