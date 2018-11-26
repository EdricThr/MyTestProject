package com.THR.ThinkingInJava.类型信息.双重分派2;

public class TSubEast1 extends TEast {
    @Override
    void goEast(TWest node) {
        node.goWest(this);
    }

    public String getName() {
        return "TSubEast1 ";
    }
}
