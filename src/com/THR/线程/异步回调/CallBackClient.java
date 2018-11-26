package com.THR.线程.异步回调;

public class CallBackClient {

    public static void main(String args[]){
        new CallBackTask(new CallBackBody() {
            @Override
            void execute(Object context) {
                System.out.println("正在执行耗时操作.....");
                System.out.println("结束执行耗时操作.....");
            }

            @Override
            void onSuccess(Object context) {
                super.onSuccess(context);
                System.out.println("执行成功。。。");
            }

            @Override
            void onFailure(Object context) {
                super.onFailure(context);
                System.out.println("执行失败。。。");
            }
        }).start("内容XXXXXXXXXXXXXXX");
    }
}
