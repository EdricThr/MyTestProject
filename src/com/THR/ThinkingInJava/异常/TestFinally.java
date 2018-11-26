package com.THR.ThinkingInJava.异常;

public class TestFinally {


    public static void main(String args[]){
        testFinallyDo();
    }

    /**
     * 验证 finally 何时会被执行
     * 可见，不管是否发生异常，finally总会被执行
     */
    public static void testFinallyDo() {

        try {
            System.out.println("执行语句");
            throw new Exception("抛出异常");
        }catch (Exception e) {
            System.out.println("进入catch");
            e.printStackTrace(System.out);
            System.out.println("结束catch");
        }finally {
            System.out.println("Finally");
        }
        System.out.println("--------------------");
        try {
            System.out.println("执行语句");
        }catch (Exception e) {
            System.out.println("进入catch");
            e.printStackTrace(System.out);
            System.out.println("结束catch");
        }finally {
            System.out.println("Finally");
        }
    }
}
