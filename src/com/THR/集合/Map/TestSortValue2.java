package com.THR.ºØ∫œ.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.LinkedMap;

import java.util.*;

public class TestSortValue2 {

    public static void main(String args[]) throws Exception {

        String str = "{order:{a:1,d:8,b:2,c:3}}";
        //String str = "{order:{}}";
        JSONObject jsonObject = JSON.parseObject(str);

        JSONObject json = jsonObject.getJSONObject("order");
        System.out.println(json.isEmpty());

        //doSortOrder(json);
        //doAdd();
        doTest();
    }

    private static void doSortOrder(JSONObject json) {

        Map<String, Integer> map = JSONObject.toJavaObject(json, Map.class);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //…˝–Ú≈≈–Ú
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getValue().intValue() - o2.getValue().intValue();
            }

        });
        JSONArray jsonArray = new JSONArray();
        for(Map.Entry<String,Integer> mapping : list){
            jsonArray.add(mapping.getKey());
        }
        System.out.println(jsonArray.toString());
    }

    private static void doAdd() {
        Map<String, String>  map =  new LinkedMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("----------------------------------------");
        map.put("a", "11");
        map.put("c", "13");
        map.put("e", "15");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public static void doTest() {
        String str = "{\"delete\":[],\"modify\":[],\"add\":[],\"order\":{\"wy.com\":\"0\",\"www.test1.com\":\"2\"}}";
         JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.toJSONString());
    }
}
