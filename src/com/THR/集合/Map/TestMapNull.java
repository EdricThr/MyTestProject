package com.THR.¼¯ºÏ.Map;

import java.util.HashMap;
import java.util.Map;

public class TestMapNull {
    public static void main(String args[]){
        Map<String,String> myMap = new HashMap<>();
        myMap = assembleMap(myMap);
        for (Map.Entry<String, String> entry: myMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static Map<String,String> assembleMap(Map<String, String> myMap) {
        myMap.put("A","a");
        return myMap;
    }
}
