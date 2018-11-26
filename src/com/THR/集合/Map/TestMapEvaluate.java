package com.THR.¼¯ºÏ.Map;

import java.util.HashMap;
import java.util.Map;

public class TestMapEvaluate {

    public static void main(String args[]){

        User user = new User();
        System.out.println(user);

        Map<String, User> map = new HashMap<>();
        map.put("a", new User("thr", 20));
        user = map.get("a");
        System.out.println(user);
        map.get("a").setAge(23);
        System.out.println(user);

        User user2 = new User("b", 0);
        map.put("b", user2);
        map.get("b").setAge(1);
        System.out.println(user2);

    }

    public static class User{
        public String UserName;
        public int age;

        public User(String userName, int age) {
            UserName = userName;
            this.age = age;
        }

        public User() {
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "UserName='" + UserName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
