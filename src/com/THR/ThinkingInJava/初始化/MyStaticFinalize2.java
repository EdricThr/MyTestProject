package com.THR.ThinkingInJava.≥ı ºªØ;

public class MyStaticFinalize2 {

    private User user1;
    private User user3 = new User(3);

    {
        user1 = new User(1);
        user2 = new User(2);
    }



    private User user2;

    static class User{
        User(int i) {
            System.out.println("new User:" + i);
        }
    }

}
