package com.THR.ThinkingInJava.������Ϣ.˫�ط���;

public class SubEast2 extends East {
    @Override
    void goEast(West west) {
        west.goWest2(this);
    }

    public String myName2() {
        return "SubEase2";
    }
}