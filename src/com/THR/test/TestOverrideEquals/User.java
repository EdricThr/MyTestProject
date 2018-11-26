package com.THR.test.TestOverrideEquals;

public class User {
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        System.out.println("调用equals " + userName);
        if (obj instanceof User) {
            User anotherUser = (User) obj;

            if (anotherUser.userName.equals(this.userName) && anotherUser.age == this.age) {
                return true;
            }
        }


        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("调用HashCode " + age);
        return this.age;
    }
}
