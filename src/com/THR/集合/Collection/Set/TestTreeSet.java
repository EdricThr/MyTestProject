package com.THR.����.Collection.Set;

import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String args[]){
        TreeSet<User> treeSet = new TreeSet();
        treeSet.add(new User(10, "aaaa"));
        treeSet.add(new User(9, "bbbb"));
        treeSet.add(new User(11, "cccc"));
        System.out.println(treeSet);

        //Integer ��д��compareTo����������ʹ������ - ����ֵ����������������
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
         * ʵ��Comparable����д���򷽷�
         * ������� - ��������Ӵ�С����
         * ��������� - ���������С��������
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
