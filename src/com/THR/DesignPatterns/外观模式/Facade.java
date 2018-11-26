package com.THR.DesignPatterns.外观模式;

public class Facade {

    private MoudleA moudleA;
    private MoudleB moudleB;

    public void doOperationA() {
        if (null == moudleA) {
            moudleA = new MoudleA();
        }
        moudleA.doOperationA();
    }
    public void doOperationB() {
        if (null == moudleB) {
            moudleB = new MoudleB();
        }
        moudleB.doOperationB();
    }
}
