package com.THR.DesignPatterns.建造者模式;

public interface Builder {

    //产品有两个对象，对应两个构建方法
    void buildPare1();
    void buildPare2();
    Product retrieveResult();
}
