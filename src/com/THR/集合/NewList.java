package com.THR.¼¯ºÏ;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thr
 */
public class NewList {

    public static void main(String args[]){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.userName = "a";
        list.add(user);
        user.userName = "b";
        user = new User();
        user.userName = "c";
        list.add(user);
        addUser(list);
        addUser(list);
        System.out.println(list.get(0).userName);
        System.out.println(list.get(1).userName);
        System.out.println(list.get(2).userName);
        System.out.println(list.get(3).userName);
    }

    private static void addUser(List<User> list) {
        User user = new User();
        user.userName = "a";
        list.add(user);
    }

    static class User {
        public String userName;
    }
}
