package com.THR.ThinkingInJava.������Ϣ.˫�ط���2;

public class TSubWest1 extends TWest {

    @Override
    void goWest(TSubEast1 east) {
        System.out.println(east.getName() + "TSubWest1");
    }

    @Override
    void goWest(TSubEast2 east) {
        System.out.println(east.getName() + "TSubWest1");
    }
}
