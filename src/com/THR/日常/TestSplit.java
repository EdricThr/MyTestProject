package com.THR.�ճ�;

/**
 * �����ַ����ָ�
 *
 * @author Thr
 */
public class TestSplit {

    public static void main(String args[]){
        testSplitOne();
    }
    public static void testSplitOne() {
        String str = "a";
        System.out.println(str.contains(";"));
        String[] array = str.split(";");
        for (String aa : array) {
            System.out.println("---" + aa + "-------");
        }
    }
}
