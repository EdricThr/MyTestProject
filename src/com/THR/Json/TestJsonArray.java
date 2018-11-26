package com.THR.Json;

import org.json.JSONArray;
import org.json.JSONException;

public class TestJsonArray {

    public static void main(String args[]) throws JSONException {
        String str = "[\"a\",b,c]";
        JSONArray ja = new JSONArray(str);
        System.out.println(ja.get(0));
        System.out.println(ja.get(1));
        System.out.println(ja.get(2));

    }
}
