package com.THR.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFastListJson {

    public static void main(String args[]){
        fastList2();
    }

    public static void fastList() {
        List<Map<String, String>> lmap = new ArrayList<>();
        Map<String, String> map1;
        for (int i = 0; i < 5; i++) {
            map1 = new HashMap<>();
            map1.put("info", "success");
            map1.put("des", "success" + i);
            lmap.add(map1);
        }
        System.out.println(new org.json.JSONArray(lmap));

        JSONArray mapJsonArray = JSONArray.parseArray(JSON.toJSONString(lmap));
        System.out.println(mapJsonArray);

        List<Map> listMap = mapJsonArray.toJavaList(Map.class);
        for (Map map3 : listMap) {
            System.out.println("info:" + map3.get("info"));
            System.out.println("des:" + map3.get("des"));
        }
    }


    public static void fastList2() {
        List<Map<String, Object>> lmap = new ArrayList<>();
        Map<String, Object> map1;
        for (int i = 0; i < 5; i++) {
            map1 = new HashMap<>();
            map1.put("info", "success");
            map1.put("des", i);
            lmap.add(map1);
        }
        System.out.println(new org.json.JSONArray(lmap));

        JSONArray mapJsonArray = JSONArray.parseArray(JSON.toJSONString(lmap));
        System.out.println(mapJsonArray);

        List<Map> listMap = mapJsonArray.toJavaList(Map.class);
        for (Map map3 : listMap) {
            System.out.println("info:" + map3.get("info"));
            System.out.println("des:" + map3.get("des"));
        }
    }
}
