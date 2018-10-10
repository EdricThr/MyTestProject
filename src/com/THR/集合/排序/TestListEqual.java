package com.THR.ºØ∫œ.≈≈–Ú;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thr
 */
public class TestListEqual {

    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        List<String> list1 = list;
        list = new ArrayList<>();
        list.add("bbb");
        list.add("bbb");
        list.add("bbb");
        System.out.println(list == list1);

        User user = new User();
        user.userName = "aaa";
        User user2 = user;
        System.out.println(user2 == user);
        user = new User();
        System.out.println(user2 == user);

    }

    static class User {
        public String userName;
    }
}
