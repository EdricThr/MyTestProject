package com.THR.ThinkingInJava.������Ϣ.˫�ط���2;

public class TSubEast1 extends TEast {
    @Override
    void goEast(TWest node) {
        node.goWest(this);
    }

    public String getName() {
        return "TSubEast1 ";
    }
}
