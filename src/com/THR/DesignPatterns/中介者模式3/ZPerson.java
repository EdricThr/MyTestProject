package com.THR.DesignPatterns.中介者模式3;

public abstract class ZPerson {

    private Mediator mediator;

    public ZPerson(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

}
