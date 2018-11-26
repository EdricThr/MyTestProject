package com.THR.ThinkingInJava.持有对象;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 测试List类方法的使用
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

        System.out.println(lists.contains(new MyObj(4, 5)));//从第一个开始equals()比较，直至匹配到第一个

        System.out.println(lists.indexOf(new MyObj(4, 5)));

        List<MyObj> subList = lists.subList(2, 5);//和String的截取一致，都是从角标是 a 开始 ，带上第一个共截取 b - a 个元素
        System.out.println(subList);

        boolean bb = lists.containsAll(subList);//其实是循环sublist查contains()，故equals会被多次调用（查sublist的一个元素就会调用多次）

        lists.add(2, new MyObj(8, 8));//添加后在角标a处就是添加的元素了

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
