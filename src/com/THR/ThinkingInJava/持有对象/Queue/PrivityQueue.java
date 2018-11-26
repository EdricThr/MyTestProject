package com.THR.ThinkingInJava.持有对象.Queue;

import java.util.*;

/**
 * 优先级队列
 * 使用Comparator控制队列的输出顺序，优先级高的先输出
 */
public class PrivityQueue {

    public static void main(String args[]){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            list.add(random.nextInt(i + 10));
        }
        priorityQueue.addAll(list);
        QueueDemo.printQ(priorityQueue);

        priorityQueue = new PriorityQueue<>(list);
        QueueDemo.printQ(priorityQueue);

        priorityQueue = new PriorityQueue<>(list.size(), Collections.<Integer>reverseOrder());
        priorityQueue.addAll(list);
        QueueDemo.printQ(priorityQueue);

    }
}
