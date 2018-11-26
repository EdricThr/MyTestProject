package com.THR.DesignPatterns.迭代子模式1;


public class ClientDieDai1 {

    public void operation() {
        Object[] objAray = {"one", "two", "three"};
        Aggregate agg = new ConcreteAggregate(objAray);

        Iterator it = agg.createIterator();
        while (!it.isDone()) {
            System.out.println(it.currentItem());
            it.next();
        }
    }


    public static void main(String args[]){
        ClientDieDai1 clientDieDai1 = new ClientDieDai1();
        clientDieDai1.operation();
    }
}
