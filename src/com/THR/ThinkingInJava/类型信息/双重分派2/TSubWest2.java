package com.THR.ThinkingInJava.������Ϣ.˫�ط���2;

public class TSubWest2 extends TWest {
    @Override
    void goWest(TSubEast1 east) {
        System.out.println(east.getName() + "TSubWest2");
    }

    @Override
    void goWest(TSubEast2 east) {
        System.out.println(east.getName() + "TSubWest2");
    }
}
