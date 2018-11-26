package com.THR.DesignPatterns.责任链模式;

public abstract class Handler {
    protected Handler handler;

    public Handler getSuccessor() {
        return handler;
    }

    public void setSuccessor(Handler handler) {
        this.handler = handler;
    }

    public abstract String hadleFeeRequest(String user, double fee);
}
