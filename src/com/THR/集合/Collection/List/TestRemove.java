package com.THR.����.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class TestRemove {

    public static void main(String args[]){
        List<String> lists = new ArrayList<>();
        lists.add("aaa");
        lists.add("aaa");
        lists.add("bbb");
        lists.add("ccc");
        lists.remove("aaa");//ArrayList��LinkedList��remove��������ɾ����һ��equals��Ԫ��
        System.out.println(lists.toString());
    }
}
