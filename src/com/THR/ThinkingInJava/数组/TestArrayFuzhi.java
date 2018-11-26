package com.THR.ThinkingInJava.����;

/**
 * ��������ĸ���
 *   �����ǻ������ͻ����������͵����飬�����ƺ��������鶼ָ��ͬһ������
 *   ����һ���������ö�������������ĸĶ��ᷴӳ����һ������������
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
