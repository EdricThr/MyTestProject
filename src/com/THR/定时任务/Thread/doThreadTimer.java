package com.THR.��ʱ����.Thread;

public class doThreadTimer {

    public static void main(String args[]){

        while (true) {
            System.out.println("-------doCircle-----" + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(3000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
