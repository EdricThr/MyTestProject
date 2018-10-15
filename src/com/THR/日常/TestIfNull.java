package com.THR.»’≥£;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thr
 */
public class TestIfNull {

    public static void main(String args[]){

        Map<String, Boolean> map = new HashMap<>();
        Boolean b = map.get("aaa");
        if (null != b && b.booleanValue()) {
            System.out.println("111111");
        } else {
            System.out.println("0000000");
        }
    }
}
