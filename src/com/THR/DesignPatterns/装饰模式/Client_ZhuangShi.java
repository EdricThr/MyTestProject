package com.THR.DesignPatterns.װ��ģʽ;

public class Client_ZhuangShi {

    public static void main(String args[]){
        Component component = new ConcreteComponent();
        component.sampleOperation();
        Component componentA = new ConcreteDecoratorA(component);
        componentA.sampleOperation();
        Component componentB = new ConcreteDecoratorB(componentA);
        componentB.sampleOperation();
    }
}
