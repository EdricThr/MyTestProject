package com.THR.ThinkingInJava.������Ϣ.˫�ط���;

public class SubWest1 extends West {
    @Override
    void goWest1(SubEast1 east) {
        System.out.println("SubWest1 + " + east.myName1());
    }

    @Override
    void goWest2(SubEast2 east) {
        System.out.println("SubWest1 + " + east.myName2());
    }
}
