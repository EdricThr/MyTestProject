package com.THR.ThinkingInJava.数组.排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 自定义数组比较的两种方式：对象实现了Comparable借口或者具有相关联的Comparator
 *  1. 对象实现Comparable接口，在compareTo方法中重写比较的规则。自己 - 形参 标识从小到大
 *  2. 如果需要另一种比较对象的方式（不管类有没有实现Comparable接口），可以创建一个实现了Comparator接口的单独的类
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
     * 第一种方式
     */
    public static void doTestImplementsComparable() {

        System.out.println(Arrays.deepToString(comArray));
        Arrays.sort(comArray);
        System.out.println("--------------------------");
        System.out.println(Arrays.deepToString(comArray));
    }

    /**
     * 第二种方式
     */
    public static void doTestComparator() {
        //也可以使用 匿名内部类
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
