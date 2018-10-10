package com.THR.�ճ�;

import java.util.*;

/**
 * ����set��صĲ���
 *
 * @author Thr
 */
public class TestSet {

    public static void main(String args[]){
        //doRemoveMapKey();
        doAddArrayToSet();
    }

    public static void doAddArrayToSet() {
        String[] array = {"aaa", "", "bbb"};
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(array));
        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void doTest1() {
        Map<String, Set<String>> stringSetMap = new HashMap<>();
        stringSetMap.put("aaa", new HashSet<String>());
        stringSetMap.put("bbb", new HashSet<String>());
        stringSetMap.get("aaa").add("111");
        stringSetMap.get("aaa").add("222");
        stringSetMap.get("bbb").add("222");
        Collection collection = stringSetMap.values();
        Object[] objects = collection.toArray();
        List<String> strings = new ArrayList<>();
        for (Set<String> str : stringSetMap.values()) {
            strings.addAll(str);
        }
        System.out.println(strings.toString());
    }

    public static void doRemoveMapKey() {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        map.put("bbb", "bbb");
        map.put("ccc", "bbb");
        Set<String> set = new HashSet<>();
        set = map.keySet();
        set.remove("aaa");

        System.out.println(map.containsKey("aaa"));
    }

    /**
     * ����set.removeAll(...)����
      */
    public static void removeSet() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("aaa");
        stringSet.add("bbb");
        stringSet.add("ccc");

        Set<String> delSet = new HashSet<>();
        delSet.add("aaa");
        delSet.add("bbb");
        delSet.add("ccc");
        stringSet.removeAll(delSet);

        for (String ss : stringSet) {
            System.out.println(ss);
        }
    }

    /**
     * ����ѭ��ʱ��̬���Ԫ�ص�set������, ���з�������ֱ��ʵ��
     */
    public static void dynamicAddSet() {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("aaa");
        stringSet.add("bbb");
        stringSet.add("ccc");
        Iterator<String> iterator = stringSet.iterator();
        String existStr;
        while (iterator.hasNext()) {
            existStr = iterator.next();
            System.out.println(existStr);
            //if (stringSet.size() < 10) {
            //    stringSet.add(existStr + "+");
            //}
        }
    }

    /**
     * ����ѭ��ʱ��̬���Ԫ�ص�list������, ����ֻ�ܽ�Ԫ����ӵ���������
     */
    public static void dynamicAddList() {
        List<String> stringSet = new ArrayList<>();
        stringSet.add("aaa");
        stringSet.add("bbb");
        stringSet.add("ccc");
        ListIterator<String> iterator = stringSet.listIterator();
        String existStr;
        while (iterator.hasNext()) {
            existStr = iterator.next();
            System.out.println(existStr);
            if (stringSet.size() < 10) {
                iterator.add(existStr + "+");
            }
        }
    }
}
