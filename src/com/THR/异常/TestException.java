package com.THR.异常;

/**
 * 测试方法中抛出异常的处理
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
