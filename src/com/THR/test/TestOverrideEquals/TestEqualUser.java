package com.THR.test.TestOverrideEquals;

import java.util.HashSet;
import java.util.Set;

public class TestEqualUser {

    public static void main(String args[]){
        User user1 = new User();
        user1.setAge(10);
        user1.setUserName("aaa");
        User user2 = new User();
        user2.setAge(10);
        user2.setUserName("bbb");
        System.out.println(user1.equals(user2));

        System.out.println("--------------------------");

        User user3 = new User();
        user3.setAge(15);
        user3.setUserName("ccc");
        System.out.println(user1.equals(user3));
        //可见，对象之间的比较只会调用equals()方法，而不会在方法内部再调用hashCode();

        System.out.println("--------------------------");

        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        //可见，在集合里添加元素，会先调用hashCode()进行比较
        // 如果不同，则直接添加，不会再调用equal()方法；
        // 如果相同，则再比较equal()方法，不同的话会添加该元素

        System.out.println("--------------------------");

        for (User user : userSet) {
            System.out.println(user.getAge() + user.getUserName());
        }
    }

}
