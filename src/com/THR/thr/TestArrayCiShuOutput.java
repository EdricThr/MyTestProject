package com.THR.thr;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 打印在数组中出现n/2以上的元素
 * 利用一个HashMap来存放数组元素及出现的次数
 */
public class TestArrayCiShuOutput {

    public static void main(String args[]){

        int array[] = new int[]{0, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        Map<Integer, Integer> valueMap = new HashMap();
        for (int i : array) {
            if (valueMap.containsKey(i)) {
                valueMap.put(i, valueMap.get(i) + 1);
            }else {
                valueMap.put(i, 1);
            }
        }

        int n = 5;
        Set<Integer> set = valueMap.keySet();
        for (int i : set) {
            if (valueMap.get(i) > n/2) {
                System.out.println("元素 " + i + ",出现" + valueMap.get(i) + "次");
            }
        }
    }
}
