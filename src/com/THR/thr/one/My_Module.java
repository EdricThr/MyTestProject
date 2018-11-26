package com.THR.thr.one;

import java.util.ArrayList;
import java.util.List;

public class My_Module <A> {
    private List<MyInterface<A>> myList;

    public My_Module(){
        myList = new ArrayList<MyInterface<A>>();
    }
    public void star(){
        for (MyInterface<A> temp : myList){
            temp.doBusiness();
        }
    }

    public static void main(String args[]){
        My_Module<Object> mm = new My_Module<Object>();
        mm.star();
    }

}
