package com.THR.DesignPatterns.�н���ģʽ3;

public abstract class ZPerson {

    private Mediator mediator;

    public ZPerson(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

}
