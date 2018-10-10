package com.THR.日常;

/**
 * 学习Intellij下的debug技巧
 *
 * @author Thr
 */
public class TestDebug {

    private static int callCount = 0;
    public static void main(String args[]){

        //User user = null;
        //markupUser(user, false);
        //user = markupUser(user, true);
        //markupUser(user, false);
        //
        //System.out.println(printUser(markupUser(user, false)));
        new MyThread().start();
        new MyThread().start();

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            threadMethod(Thread.currentThread().getName());
        }
    }

    public static void threadMethod(String callName) {
        System.out.println("-------" + callName + ++callCount + "-------");
    }

    public static User markupUser(User user, boolean nullAccepted) {
        System.out.println("------第" + ++callCount + "次开始调用markupUser------");
        if (user == null && nullAccepted) {
            System.out.println("------对user进行赋值------");
            user = new User();
            user.setUserName("method_One" + callCount);
            user.setAge(20);
        }
        System.out.println("------第" + callCount + "次结束调用markupUser------");
        return user;
    }

    public static String printUser(User user) {
        return user.toString();
    }

    public static void outUser(String user) {
        System.out.println();
    }

    static class User {
        public String userName;
        public int age;

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
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
