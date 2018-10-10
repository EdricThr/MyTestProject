package com.THR.ºØ∫œ.≈≈–Ú;

import java.util.*;

/**
 * @author Thr
 */
public class CollectionSort {

    public static void main(String args[]) throws InterruptedException {
        Date date1 = new Date();
        Thread.sleep(2000);
        Date date2 = new Date();
        Date[] dates = {date1, date2};
        Arrays.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        for (Date date : dates) {
            System.out.println(date.getTime());
        }
    }
}
