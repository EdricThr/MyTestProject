package com.THR.Json.Json;

import com.base.util.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class JsonTestOne {

    public static void main(String args[]) throws JSONException {
        String str = "{dept:0,user:0}";
        JSONObject jsonObj = new JSONObject(str);

        Iterator<?> iterator = jsonObj.keys();
        String key = null;
        int value;
        while(iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObj.getInt(key);
        }


        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 10000; i++){
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        String sss = sb.toString().trim();
        System.out.println(sss);

        JSONArray ja = new JSONArray(sss);
        List<String> sssList = new ArrayList<>();
        Map<String,String> sssMap = new HashMap<>();
        for (int i = 0; i <  ja.length(); i++){
            sssList.add(ja.get(i).toString());
            sssMap.put(ja.get(i).toString(),ja.get(i).toString());
        }

        long liststartTime = System.currentTimeMillis();
        System.out.print("list匹配起始时间：");
        System.out.println(liststartTime);
        for (int i = 10; i < 10000; i += 10){
            if (sssList.contains(Integer.toString(i))) {
                System.out.print("匹配成功：");
                System.out.println(i);
            }
        }
        System.out.print("list匹配终止时间：");
        System.out.print(System.currentTimeMillis());
        System.out.print("；list匹配耗时：");
        System.out.println(System.currentTimeMillis() - liststartTime);

        long mapstartTime = System.currentTimeMillis();
        System.out.print("map匹配起始时间：");
        System.out.println(mapstartTime);
        for (int i = 10; i < 10000; i += 10){
            String vv = sssMap.get(Integer.toString(i));
            if (StringUtil.isNotEmpty(vv)) {
                System.out.print("匹配成功：");
                System.out.println(vv);
            }
        }
        System.out.print("map匹配终止时间：");
        System.out.print(System.currentTimeMillis());
        System.out.print("；map匹配耗时：");
        System.out.println(System.currentTimeMillis() - mapstartTime);

    }
}
