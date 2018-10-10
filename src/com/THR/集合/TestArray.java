package com.THR.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试Array相关的操作
 *
 * @author Thr
 */
public class TestArray {

    public static void main(String args[]){
        doCopyArray();
    }
    public static void doCopyArray() {
        String[] array = new String[5];
        array[0] = "aa";
        array[1] = "bb";
        array[4] = "cc";

        String[] array2 = Arrays.copyOf(array, 4);

        array[0] = "aaa";
        array[1] = "bbb";
        array[4] = "ddd";
        System.out.println(array);

        doOutArray(array);
        System.out.println(array2);
        array2[2] = "ccc";
        doOutArray(array2);
        List<String[]> list =new ArrayList<>();
        list.add(array);
        list.add(array2);
        for (String[] ss : list) {
            doOutArray(ss);
        }
    }


    public static void doOutArray(Object[] array) {
        for (Object obj : array) {
            System.out.print(obj + ", ");
        }
        System.out.println();
    }
}
