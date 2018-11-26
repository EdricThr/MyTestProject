package com.THR.¼¯ºÏ.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class TestChangeInnerValue {

    public static void main(String args[]){
        List<User> userList = new ArrayList<>();
        userList.add(new User("aaaaa"));
        userList.add(new User("bbbbb"));
        userList.add(new User("ccccc"));
        userList.add(new User("ddddd"));
        changeListInnerValue(userList);
        System.out.println(userList.get(0).getUserName());
    }

    private static void changeListInnerValue(List<User> userList) {
        User user = userList.get(0);
        user.setUserName("111111111");
    }

    static class User {
        String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
