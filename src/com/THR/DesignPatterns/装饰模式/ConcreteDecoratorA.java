package com.THR.DesignPatterns.װ��ģʽ;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteDecoratorA �߼�������������");
        super.sampleOperation();
        System.out.println("ConcreteDecoratorA �߼�������������");
    }
}
