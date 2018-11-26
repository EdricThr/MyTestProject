package com.THR.ThinkingInJava.持有对象;


import com.THR.ThinkingInJava.持有对象.LinkedList.Stack;

public class TestLinkedListClient {

    public static void main(String args[]){
        testStack();
    }
    public static void testStack() {
        Stack<String> stringStack = new Stack<>();
        System.out.println(stringStack.empty());
        stringStack.push("aaa");
        stringStack.push("bbb");
        stringStack.push("ccc");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.peek());
    }
}
