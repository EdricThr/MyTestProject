package com.THR.赋值;

public class 引用类型 {

    static class User{
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public static void main(String args[]){
        User user = new User();
        user.setUserName("Tom");
        System.out.println(user.getUserName());
        alterUserValue(user);
        System.out.println(user.getUserName());

    }
    public static void alterUserValue(User user){
        user.setUserName("THR");
    }
}
