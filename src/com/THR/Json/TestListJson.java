package com.THR.Json;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TestListJson {

    public static void main(String args[]){
        List<String> lists = new ArrayList<>();
        lists.add("aaaa");
        lists.add("bbbb");
        System.out.println(new JSONArray(lists).toString());
        Set<String> set = new LinkedHashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("aa");
        System.out.println(set.toArray());
        System.out.println(set.toString());
    }
}
