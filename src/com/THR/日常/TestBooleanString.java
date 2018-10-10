package com.THR.日常;

/**
 * 查看Boolean类型的String输出
 *
 * @author Thr
 */
public class TestBooleanString {


    public static void main(String args[]){

        System.out.println(Boolean.TRUE.toString());
        System.out.println(Boolean.FALSE.toString());
        Bol b = new Bol();
        //System.out.println(b.aBoolean.equals(Boolean.TRUE));
        Boolean b2 = Boolean.TRUE;
        if (b2) {
            System.out.println("---------------");
        }
    }
    static class Bol{
        public Boolean aBoolean;
    }
}
