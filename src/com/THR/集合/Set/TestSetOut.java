package com.THR.集合.Set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 测试Set各实现类的toString
 *
 * @author Thr
 */
public class TestSetOut {

    public static void main(String args[]){
        testLinkedHashSet();
    }
    public static void testLinkedHashSet() {
        Set<String> set = new LinkedHashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ggg");
        System.out.println(set);
        Set<String> set2 = new LinkedHashSet<>();
        set2.addAll(set);
        set2.add("ddd");
        set2.add("eee");
        set2.add("fff");
        System.out.println(set2);
    }
}
