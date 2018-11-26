package com.THR.DesignPatterns.�н���ģʽ2;

public class CDDriver extends Colleague {

    private String data = "";

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    public String getData() {
        return data;
    }

    public void readCD() {
        this.data = "One Piece, �������ҵ�����";
        //֪ͨ���壬�Լ���״̬�����˸ı�
        getMediator().changed(this);
    }
}
