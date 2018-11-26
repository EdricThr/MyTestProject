package com.THR.ThinkingInJava.持有对象;

import java.util.Iterator;

/**
 * Foreach与迭代器
 * 所有实现了Iterable 的类，都可以将它用于foreach语句中
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
                    throw new Exception("不能调用remove......");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
