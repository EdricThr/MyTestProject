package com.THR.�߳�.�첽�ص�;

public class CallBackClient {

    public static void main(String args[]){
        new CallBackTask(new CallBackBody() {
            @Override
            void execute(Object context) {
                System.out.println("����ִ�к�ʱ����.....");
                System.out.println("����ִ�к�ʱ����.....");
            }

            @Override
            void onSuccess(Object context) {
                super.onSuccess(context);
                System.out.println("ִ�гɹ�������");
            }

            @Override
            void onFailure(Object context) {
                super.onFailure(context);
                System.out.println("ִ��ʧ�ܡ�����");
            }
        }).start("����XXXXXXXXXXXXXXX");
    }
}
