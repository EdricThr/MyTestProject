package com.THR.thr;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ��ӡ�������г���n/2���ϵ�Ԫ��
 * ����һ��HashMap���������Ԫ�ؼ����ֵĴ���
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
                System.out.println("Ԫ�� " + i + ",����" + valueMap.get(i) + "��");
            }
        }
    }
}
