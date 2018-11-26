package com.THR.¼¯ºÏ.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class TestListToArray {
    public static void main(String args[]){
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = list.toArray(new Integer[]{});
        for (Integer i : array) {
            System.out.println(i);
        }
    }
}
