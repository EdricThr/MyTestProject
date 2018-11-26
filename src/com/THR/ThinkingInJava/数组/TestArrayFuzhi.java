package com.THR.ThinkingInJava.数组;

/**
 * 测试数组的复制
 *   不管是基本类型还是引用类型的数组，被复制后，两个数组都指向同一个引用
 *   其中一个数组引用对数组对象做出的改动会反映在另一个数组引用上
 */
public class TestArrayFuzhi {

    public static void main(String args[]){
        copyStingArray();
    }
    public static void copyStingArray() {
        String[] array1 = {"aaa", "bbb"};
        String[] array2 = {"ddd", "ccc"};
        print(array1);
        print(array2);
        array2 = array1;
        print(array2);
        array1[0] = "eeee";
        print(array1);
        print(array2);
    }


    public static void copyIntArray() {
        int a[] = {1, 2, 3, 4};
        int b[] = {2, 3};
        b = a;
        print(a);
        print(b);
        System.out.println("-------------");
        a[0] = 8;
        print(a);
        print(b);
    }
    private static void print(int[] c) {
        for (int o : c) {
            System.out.print(o + " , ");
        }
        System.out.println();
    }
    private static void print(Object[] c) {
        for (Object o : c) {
            System.out.print(o + " , ");
        }
        System.out.println();
    }
}
