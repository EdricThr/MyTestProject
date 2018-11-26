package com.THR.ThinkingInJava.≥ı ºªØ;

public class MyStaticFinalize {

    private static User user1;


    static {
        user1 = new User(1);
        user2 = new User(2);
    }


    private static User user3 = new User(3);
    private static User user2;

    static class User{
        User(int i) {
            System.out.println("new User:" + i);
        }
    }

}
