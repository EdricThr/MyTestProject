package com.THR.ThinkingInJava.������Ϣ.˫�ط���;

public class SubWest2 extends West {
    @Override
    void goWest1(SubEast1 east) {

        System.out.println("SubWest2 + " + east.myName1());
    }

    @Override
    void goWest2(SubEast2 east) {
        System.out.println("SubWest2 + " + east.myName2());
    }
}
