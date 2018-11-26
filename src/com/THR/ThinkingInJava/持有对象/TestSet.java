package com.THR.ThinkingInJava.持有对象;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    public static void main(String args[]){
        testBasicMethods();
    }
    public static void testBasicMethods() {
        Set<MyObj> myObjs = new HashSet<>();

        myObjs.add(new MyObj(1, 2));
        System.out.println("--------------------");
        myObjs.add(new MyObj(2, 3));
        System.out.println("--------------------");
        myObjs.add(new MyObj(3, 4));
        System.out.println("--------------------");
        myObjs.add(new MyObj(3, 5));
        System.out.println("--------------------");
        myObjs.add(new MyObj(4, 5));
        System.out.println("--------------------");

        System.out.println(myObjs);

    }
}
