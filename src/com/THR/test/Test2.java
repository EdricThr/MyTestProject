package com.THR.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class Test2 {

    public static void main(String args[]){

        Object stt = 10;

        String aa22 = String.valueOf(stt);
        System.out.println(aa22);



        Map<String, String> map = new HashMap<>();
        map.put("aa", "bb");
        map.put("aa", "cc");
        System.out.println(map.get("aa"));
        JSONObject jsonObject = JSONObject.parseObject("{\"aa\":\"bbb\"}");
        System.out.println(jsonObject.get("aa"));
        JSONArray jsonArray = JSONArray.parseArray("[\"aaa\",\"bbb\"]");
        String[] aa= {"aaa", "bbb"};
        System.out.println(aa);
        System.out.println(jsonArray.toArray());
        System.out.println(jsonArray.toJavaList(String.class));


        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("22");
        stringList.add("333");
        stringList.add("4444");

        JSONArray strJsonArray = JSONArray.parseArray(JSON.toJSONString(stringList));
        Iterator iterator = strJsonArray.iterator();
        System.out.println("---------------------");
        while (iterator.hasNext()) {
           String ss = (String) iterator.next();
            System.out.println(ss);
        }
    }
}
