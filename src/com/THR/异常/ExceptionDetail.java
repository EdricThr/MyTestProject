package com.THR.异常;

public class ExceptionDetail {

    public static void main(String args[]){

        try {
            Object user = null;
            if (null == user) {
                throw new Exception("我是异常信息");
                //throw new Exception();
            }
        } catch (Exception e) {
            if (null != e.getMessage() && e.getMessage().contains("我是异常信息")) {
                System.out.println("----------");
            }else{

                System.out.println("e.getMessage():" + e.getMessage());
                System.out.println("e.toString():" + e.toString());
                System.out.println("e.fillInStackTrace():" + e.fillInStackTrace());
                System.out.println("e.getLocalizedMessage():" + e.getLocalizedMessage());
                System.out.println("e.getStackTrace()" + e.getStackTrace());
                System.out.println("e.getSuppressed():" + e.getSuppressed());
                System.out.println("e.getCause():" + e.getCause());
                //e.printStackTrace();
            }
        }
    }
}
