package com.THR.集合.Collection.Set;

import java.util.HashSet;
import java.util.Set;

public class TestAdd {

    public static void main(String args[]){
        testAddAll();
    }
    public static void testAdd() {

    }
    public static void testAddAll() {
        Set<String> set1 = new HashSet<>();
        set1.add("aaa");
        set1.add("bbb");

        Set<String> set2 = new HashSet<>();
        set2.add("bbb");
        set2.add("ccc");

        System.out.println(set1.addAll(set2));
        /**
         * Set.addAll( Set );
         * 会添加参数中collection中未在本set中包含的元素;
         * 只要添加一个元素就会返回true,若一个元素都没添加，返回false
         */
        System.out.println(set1.toString());
    }
}
