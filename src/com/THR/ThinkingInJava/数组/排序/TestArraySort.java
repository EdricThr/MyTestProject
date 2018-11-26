package com.THR.ThinkingInJava.����.����;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * �Զ�������Ƚϵ����ַ�ʽ������ʵ����Comparable��ڻ��߾����������Comparator
 *  1. ����ʵ��Comparable�ӿڣ���compareTo��������д�ȽϵĹ����Լ� - �β� ��ʶ��С����
 *  2. �����Ҫ��һ�ֱȽ϶���ķ�ʽ����������û��ʵ��Comparable�ӿڣ������Դ���һ��ʵ����Comparator�ӿڵĵ�������
 */
public class TestArraySort {

    public static final CompType[] comArray = new CompType[]{
            new CompType(1,4),
            new CompType(4,2),
            new CompType(3,1),
            new CompType(2,3),
    };
    public static void main(String args[]){
        //doTestImplementsComparable();
        doTestComparator();
    }

    /**
     * ��һ�ַ�ʽ
     */
    public static void doTestImplementsComparable() {

        System.out.println(Arrays.deepToString(comArray));
        Arrays.sort(comArray);
        System.out.println("--------------------------");
        System.out.println(Arrays.deepToString(comArray));
    }

    /**
     * �ڶ��ַ�ʽ
     */
    public static void doTestComparator() {
        //Ҳ����ʹ�� �����ڲ���
        class ComptypeComparator implements Comparator<CompType> {
            @Override
            public int compare(CompType o1, CompType o2) {
                return o1.j - o2.j;
            }
        }
        System.out.println(Arrays.deepToString(comArray));
        System.out.println("--------------------------");
        Arrays.sort(comArray, Collections.reverseOrder());
        System.out.println(Arrays.deepToString(comArray));
        System.out.println("--------------------------");
        Arrays.sort(comArray, new ComptypeComparator());
        System.out.println("--------------------------");
        System.out.println(Arrays.deepToString(comArray));
    }

}
