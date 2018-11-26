package com.THR.DesignPatterns.������ģʽ;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPare1() {
        product.setPart1("��ţ� 111111");
    }

    @Override
    public void buildPare2() {
        product.setPart2("���ƣ�222222");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
