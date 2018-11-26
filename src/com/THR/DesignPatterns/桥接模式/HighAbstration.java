package com.THR.DesignPatterns.桥接模式;

/**
 * 可以继续定义超类，并聚合上一级超类，达到组合业务的效果
 */
public abstract class HighAbstration {
    private Abstraction abs;

    public HighAbstration(Abstraction abs) {
        this.abs = abs;
    }

    public void highOperation() {
        abs.operation();
    }
}
