package com.THR.DesignPatterns.模板模式;

public class ConcreteTemplete extends AbstractMethod {

    //基本方法的实现，实现不同子类本身的逻辑
    @Override
    protected void abstractMethod() {
        //本身逻辑实现
    }

    @Override
    protected void hookMethod() {
        //本身逻辑实现
        super.hookMethod();
        //本身逻辑实现
    }
}
