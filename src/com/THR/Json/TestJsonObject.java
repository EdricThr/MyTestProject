package com.THR.Json;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


public class TestJsonObject {

    public static void main(String args[]) throws JSONException {
        //String str = "{syncDeptId:\"\",syncDeptName:\"\",syncPDeptId:\"\"}";
        String str = "{syncDeptId:a,syncDeptName:bbb,syncPDeptId:\"cccc\"}";
        JSONObject jsonObject = new JSONObject(str);
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println("key:" + key + ";value:" + jsonObject.get(key));
        }
        //System.out.println(jsonObject.get("fafdafaf"));

        jsonObject = new JSONObject();
        jsonObject.put("a","11");
        jsonObject.put("b","12");
        jsonObject.put("c","13");
        System.out.println(jsonObject.toString());

        doOne();


    }


    public static void doOne() throws JSONException {
        String str = "{order:{a:1,b:2,c:3}}";
        JSONObject jsonObject = new JSONObject(str);
        JSONObject jj = jsonObject.getJSONObject("order");
        Iterator iterator = jj.keys();
        while(iterator.hasNext()) {
            String key = (String)iterator.next();
            System.out.println(key + ":" + jj.get(key));
        }
    }
}
