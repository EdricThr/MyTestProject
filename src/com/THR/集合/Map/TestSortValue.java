package com.THR.����.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class TestSortValue {

    public static void main(String args[]) throws Exception {

        //String str = "{order:{a:1,d:8,b:2,c:3}}";
        String str = "{order:{}}";
        JSONObject jsonObject = new JSONObject(str);

        if (!jsonObject.has("order")) {
            throw new Exception("�������ݲ�����");
        }

        JSONObject json = jsonObject.getJSONObject("order");

        System.out.println(json);

        doSortOrder(json);

    }

    private static void doSortOrder(JSONObject json) throws JSONException {

        Map<String, Integer> map = new HashMap<>();
        Iterator iterator = json.keys();
        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            map.put(key, (Integer) json.get(key));
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //��������
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getValue().intValue() - o2.getValue().intValue();
            }

        });
        JSONArray jsonArray = new JSONArray();
        for(Map.Entry<String,Integer> mapping : list){
            jsonArray.put(mapping.getKey());
        }
        System.out.println(jsonArray.toString());
    }
}
