package com.THR.ThinkingInJava.������Ϣ.˫�ط���;

public class SubEast1 extends East {
    @Override
    void goEast(West west) {
        west.goWest1(this);
    }

    public String myName1() {
        return "SubEase1";
    }
}