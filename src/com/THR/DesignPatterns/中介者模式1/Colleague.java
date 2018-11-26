package com.THR.DesignPatterns.�н���ģʽ1;

public abstract class Colleague {

    //����һ����ͣ�߶���
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}
