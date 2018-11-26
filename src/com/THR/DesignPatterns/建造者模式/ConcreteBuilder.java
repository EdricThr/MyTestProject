package com.THR.DesignPatterns.建造者模式;

public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPare1() {
        product.setPart1("编号： 111111");
    }

    @Override
    public void buildPare2() {
        product.setPart2("名称：222222");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
