package com.THR.ThinkingInJava.持有对象.LinkedList;

import java.util.LinkedList;

/**
 * LinkedList实现栈
 *  后进先出（LIFO）
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
