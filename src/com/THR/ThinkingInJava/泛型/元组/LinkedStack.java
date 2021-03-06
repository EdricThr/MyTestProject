package com.THR.ThinkingInJava.����.Ԫ��;

public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {
            item = null;
            next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
    private Node<T> top = new Node<>();
    public void push (T t) {
        top = new Node<>(t, top);
    }
    public T pop() {
        T result = top.item;
        if (! top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String args[]){
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "aa bb cc dd ee".split(" ")) {
            lss.push(s);
        }
        String ss;
        while ((ss = lss.pop()) != null) {
            System.out.println(ss);
        }
    }
}
