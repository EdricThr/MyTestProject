package com.THR.¶ÔÏó;

import java.util.HashSet;
import java.util.Set;

public class ÖØĞ´Equal {

    public static void main(String args[]){
        Set<User> userSet = new HashSet<>();
        User user;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.UserName = "user" + i;
            user.age = 20 + i;
            userSet.add(user);
        }
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.UserName = "user" + i;
            user.age = 20 + i;
            userSet.add(user);
        }
        System.out.println(userSet);
        for (User user1 : userSet) {
            System.out.println(user1);
        }
    }
    static class User{
        String UserName;
        int age;

        @Override
        public boolean equals(Object o) {
            System.out.println("-----------------equals()---------------");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return UserName != null ? UserName.equals(user.UserName) : user.UserName == null;
        }

        @Override
        public int hashCode() {
            System.out.println("-----------------hashCode()---------------");
            int result = UserName != null ? UserName.hashCode() : 0;
            result = 31 * result + age;
            return result;
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
