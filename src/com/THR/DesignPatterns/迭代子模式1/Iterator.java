package com.THR.DesignPatterns.迭代子模式1;

public interface Iterator {

    void first();

    void next();

    boolean isDone();

    Object currentItem();
}
