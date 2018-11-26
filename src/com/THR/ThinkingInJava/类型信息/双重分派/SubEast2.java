package com.THR.ThinkingInJava.类型信息.双重分派;

public class SubEast2 extends East {
    @Override
    void goEast(West west) {
        west.goWest2(this);
    }

    public String myName2() {
        return "SubEase2";
    }
}