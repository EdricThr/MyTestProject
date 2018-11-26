package com.THR.ThinkingInJava.类型信息.双重分派;

public class SubEast1 extends East {
    @Override
    void goEast(West west) {
        west.goWest1(this);
    }

    public String myName1() {
        return "SubEase1";
    }
}