package com.THR.DesignPatterns.组合模式;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("leaf name: " + name);
    }
}
