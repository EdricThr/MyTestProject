package com.THR.ThinkingInJava.���ж���.LinkedList;

import java.util.LinkedList;

/**
 * LinkedListʵ��ջ
 *  ����ȳ���LIFO��
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){
        storage.addFirst(v);
    }
    public T peek() {
        return storage.getFirst();
    }
    public T pop() {
        return storage.removeFirst();
    }
    public boolean empty() {
        return storage.isEmpty();
    }

}
