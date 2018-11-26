package com.THR.DesignPatterns.中介者模式2;

public class CDDriver extends Colleague {

    private String data = "";

    public CDDriver(Mediator mediator) {
        super(mediator);
    }

    public String getData() {
        return data;
    }

    public void readCD() {
        this.data = "One Piece, 海贼王我当定了";
        //通知主板，自己的状态发生了改变
        getMediator().changed(this);
    }
}
