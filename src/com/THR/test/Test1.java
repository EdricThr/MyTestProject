package com.THR.test;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main(String args[]){
        User user = new User();
        updateUser(user);
        System.out.println(user.userName);

        Set<String> ss = new HashSet<>();
        ss.add("aaa");
        ss.add("bbb");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("set", ss);
        System.out.println(jsonObject.toJSONString());

    }

    public static void updateUser(User user) {
        user.userName = "thr";
    }
    static class User{
        String userName;
    }

}
