package com.THR.DesignPatterns.ÏíÔªÄ£Ê½;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private Map<String ,Flyweight> files = new HashMap<>();

    public Flyweight factory(String intrinsicState) {
        Flyweight flyweight = files.get(intrinsicState);
        if (null == flyweight) {
            flyweight = new ConcreteFlyweight(intrinsicState);
            files.put(intrinsicState, flyweight);
        }
        return flyweight;
    }
}
