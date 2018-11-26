package com.THR.DesignPatterns.装饰模式;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteDecoratorB 逻辑开始。。。。");
        super.sampleOperation();
        System.out.println("ConcreteDecoratorB 逻辑结束。。。。");
    }
}
