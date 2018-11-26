package com.THR.ThinkingInJava.类型信息.双重分派2;

import java.util.ArrayList;
import java.util.List;

public class TStructure {

    private List<TEast> easts = new ArrayList<>();
    public void action(TWest west) {
        for (TEast east : easts) {
            east.goEast(west);
        }
    }

    public void add(TEast east) {
        easts.add(east);
    }

}
