package com.THR.ThinkingInJava.���ж���;

import java.util.Iterator;

/**
 * Foreach�������
 * ����ʵ����Iterable ���࣬�����Խ�������foreach�����
 */
public class IterableClass implements Iterable<String> {

    protected String[] words = ("aa bb cc dd ee tt yy ii").split(" ");

    public static void main(String args[]){
        for (String s : new IterableClass()) {
            System.out.print(s + "   ");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                try {
                    throw new Exception("���ܵ���remove......");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
