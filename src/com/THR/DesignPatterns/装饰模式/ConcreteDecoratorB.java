package com.THR.DesignPatterns.װ��ģʽ;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteDecoratorB �߼���ʼ��������");
        super.sampleOperation();
        System.out.println("ConcreteDecoratorB �߼�������������");
    }
}
