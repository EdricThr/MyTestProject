package com.THR.DesignPatterns.�н���ģʽ3;

public class HouseOwner extends ZPerson {


    private String complay;

    public HouseOwner(Mediator mediator) {
        super(mediator);
    }

    public void setComplay(String complay) {
        this.complay = complay;
    }

    public void speak() {
        System.out.println("�ظ�" + complay + " : ���з�Դ������Ҵ��㻰");
    }
}
