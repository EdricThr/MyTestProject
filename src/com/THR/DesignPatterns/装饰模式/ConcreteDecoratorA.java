package com.THR.DesignPatterns.装饰模式;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteDecoratorA 逻辑结束。。。。");
        super.sampleOperation();
        System.out.println("ConcreteDecoratorA 逻辑结束。。。。");
    }
}
