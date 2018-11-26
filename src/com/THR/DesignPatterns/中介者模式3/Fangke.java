package com.THR.DesignPatterns.�н���ģʽ3;

public class Fangke extends ZPerson {

    private String ask;

    public Fangke(Mediator mediator) {
        super(mediator);
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAsk() {
        return ask;
    }

    public void apply(String ask) {
        this.ask = ask;
        getMediator().constract(this);
    }

}
