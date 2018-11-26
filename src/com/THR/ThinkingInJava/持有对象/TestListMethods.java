package com.THR.ThinkingInJava.���ж���;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ����List�෽����ʹ��
 */
public class TestListMethods {

    public static void main(String args[]){

        List<MyObj> lists = new ArrayList<>();
        lists.add(new MyObj(2, 3));
        lists.add(new MyObj(3, 4));
        lists.add(new MyObj(4, 5));
        lists.add(new MyObj(5, 6));
        lists.add(new MyObj(6, 7));
        lists.add(new MyObj(7, 8));
        lists.add(new MyObj(8, 9));
        lists.add(new MyObj(9, 10));

        System.out.println(lists.contains(new MyObj(4, 5)));//�ӵ�һ����ʼequals()�Ƚϣ�ֱ��ƥ�䵽��һ��

        System.out.println(lists.indexOf(new MyObj(4, 5)));

        List<MyObj> subList = lists.subList(2, 5);//��String�Ľ�ȡһ�£����ǴӽǱ��� a ��ʼ �����ϵ�һ������ȡ b - a ��Ԫ��
        System.out.println(subList);

        boolean bb = lists.containsAll(subList);//��ʵ��ѭ��sublist��contains()����equals�ᱻ��ε��ã���sublist��һ��Ԫ�ؾͻ���ö�Σ�

        lists.add(2, new MyObj(8, 8));//��Ӻ��ڽǱ�a��������ӵ�Ԫ����

        System.out.println("------------------------");
        System.out.println(lists);

        System.out.println("------------------------");

        ListIterator<MyObj> iterator1 = lists.listIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.nextIndex());
            System.out.println(iterator1.next() + "," + iterator1.nextIndex() + "," + iterator1.previousIndex());
        }
        System.out.println("++++++++++++++++++++++++++=");
        while (iterator1.hasPrevious()) {
            System.out.println(iterator1.previous() + "," + iterator1.nextIndex() + "," + iterator1.previousIndex());
        }

    }


}
