package com.THR.集合.Collection.Set;

import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String args[]){
        TreeSet<User> treeSet = new TreeSet();
        treeSet.add(new User(10, "aaaa"));
        treeSet.add(new User(9, "bbbb"));
        treeSet.add(new User(11, "cccc"));
        System.out.println(treeSet);

        //Integer 重写了compareTo方法，并且使用自身 - 参数值，所以是升序排序
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(1);
        integerTreeSet.add(4);
        integerTreeSet.add(2);
        System.out.println(integerTreeSet);
    }

    static class User implements Comparable {
        int age;
        String userName;

        public User(int age, String userName) {
            this.age = age;
            this.userName = userName;
        }

        /**
         * 实现Comparable，重写排序方法
         * 如果参数 - 本对象，则从大到小排序
         * 如果本对象 - 参数，则从小到大排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            return age - ((User)o).age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }
}
