package com.THR.����.Collection.Set;

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
         * ����Ӳ�����collection��δ�ڱ�set�а�����Ԫ��;
         * ֻҪ���һ��Ԫ�ؾͻ᷵��true,��һ��Ԫ�ض�û��ӣ�����false
         */
        System.out.println(set1.toString());
    }
}
