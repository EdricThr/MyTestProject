package com.THR.集合.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class TestRemove {

    public static void main(String args[]){
        List<String> lists = new ArrayList<>();
        lists.add("aaa");
        lists.add("aaa");
        lists.add("bbb");
        lists.add("ccc");
        lists.remove("aaa");//ArrayList、LinkedList的remove方法，会删除第一个equals的元素
        System.out.println(lists.toString());
    }
}
