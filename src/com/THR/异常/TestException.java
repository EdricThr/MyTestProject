package com.THR.�쳣;

/**
 * ���Է������׳��쳣�Ĵ���
 *
 * @author Thr
 */
public class TestException {

    public static void main(String args[]){

    }

    public void doThrowException() {
        if ("aa".equals("aa")) {
            throw new MyException("");
        }
        //throw new Exception("");
        try {

        }catch (Exception e) {
            throw e;
        }
    }
}
