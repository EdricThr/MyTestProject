package com.THR.并发编程;

/**
 * Thread 的 run() 方法 和 Thread() 的区别
 *
 * @author Thr
 */
public class Run2Start {

    /**
     * 当程序正常运行时，输出结果如下：
         当前线程号：1
         -------->run()  第1个 线程, 线程号：1
         -------->run()  第2个 线程, 线程号：1
         -------->run()  第3个 线程, 线程号：1
         -------->run()  第6个 线程, 线程号：12
         -------->run()  第6个 线程, 线程号：13
         -------->run()  第6个 线程, 线程号：14
     当程序调试运行时，结果如下：
         当前线程号：1
         -------->run()  第1个 线程, 线程号：1
         -------->run()  第2个 线程, 线程号：1
         -------->run()  第3个 线程, 线程号：1
         -------->run()  第4个 线程, 线程号：14
         -------->run()  第5个 线程, 线程号：15
         -------->run()  第6个 线程, 线程号：16
     从以上可以看出：
        1. 直接调用新建线程的run方法，线程会创建，但是是通过主线程运行（过程和普通方法调用相同）
        2. 调用新建线程的start()方法，会使用新建线程调用run()方法
        3. 程序正常运行和调试运行时，输出的run()方法中的 第 n 个 的 n 不同，应该是因为主程序运行过快，
            子线程全部建立完成后，子线程的方法才开始陆续执行
     * @param args
     */
    public static void main(String args[]){

        System.out.println("当前线程号：" + Thread.currentThread().getId());
        Thread thread1 = new MyThread();
        thread1.run();
        Thread thread2 = new MyThread();
        thread2.run();
        Thread thread3 = new MyThread();
        thread3.run();

        Thread thread4 = new MyThread();
        thread4.start();
        Thread thread5 = new MyThread();
        thread5.start();
        Thread thread6 = new MyThread();
        thread6.start();
    }
}
