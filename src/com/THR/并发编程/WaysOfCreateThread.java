package com.THR.并发编程;

/**
 * 创建线程的集中方式
 *
 * @author Thr
 */
public class WaysOfCreateThread {

    /**
     * 创建线程的方式有两种：
     *  1. 继承Thread. 创建类继承Thread类，重写run()方法实现自身逻辑。
     *  2. 实现Runnable. 使用匿名内部类或创建子类实现Runnable接口,结合Thread实现
     * @param args
     */
    public static void main(String args[]){
        MyThread myThread = new MyThread();
        myThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类runnable的方式创建线程， 运行。。。线程号：" + Thread.currentThread().getId());
            }
        }).start();
        Thread runThread = new Thread(new myRunnable());
        runThread.start();
    }
    static class myRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("使用内部类runnable的方式创建线程， 运行。。。线程号：" + Thread.currentThread().getId());
        }
    }

}
