package com.THR.ThinkingInJava.���ж���.Queue;

import java.util.*;

/**
 * ���ȼ�����
 * ʹ��Comparator���ƶ��е����˳�����ȼ��ߵ������
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
