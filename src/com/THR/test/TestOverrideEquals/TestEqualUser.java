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
        //�ɼ�������֮��ıȽ�ֻ�����equals()�������������ڷ����ڲ��ٵ���hashCode();

        System.out.println("--------------------------");

        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        //�ɼ����ڼ��������Ԫ�أ����ȵ���hashCode()���бȽ�
        // �����ͬ����ֱ����ӣ������ٵ���equal()������
        // �����ͬ�����ٱȽ�equal()��������ͬ�Ļ�����Ӹ�Ԫ��

        System.out.println("--------------------------");

        for (User user : userSet) {
            System.out.println(user.getAge() + user.getUserName());
        }
    }

}
