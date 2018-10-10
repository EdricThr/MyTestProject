package com.THR.并发编程.ThreadMethods;

/**
 * @author Thr
 */
public class TestYieldMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        doTestYieldMethod();
    }



    /**
     * 如果不加锁，程序运行结果如下：
     当前线程ID:10; i:10
     线程开始调用yield()方法
     当前线程ID:9; i:10
     线程开始调用yield()方法
     当前线程yield结束，ID:10; i:11
     当前线程yield结束，ID:9; i:12

     * 如果加锁，程序运行结果如下：
     当前线程ID:10; i:10
     线程开始调用yield()方法
     当前线程yield结束，ID:10; i:11
     当前线程ID:9; i:12
     线程开始调用yield()方法
     当前线程yield结束，ID:9; i:13

     可见：
     1. 线程的yield()方法属于Thread，但是不需要处理异常
     2. yield()方法同样不会释放对象锁
     3. 须知：yield()不能控制具体的交出CPU的时间; 另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。
     */
    public static void doTestYieldMethod() {
        TestYieldMethod testYieldMethod = new TestYieldMethod();
        testYieldMethod.new MyYieldBlockTestThread().start();
        testYieldMethod.new MyYieldBlockTestThread().start();
    }

    class MyYieldBlockTestThread extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("当前线程ID:" + Thread.currentThread().getId() + "; i:" + i++);
                System.out.println("线程开始调用yield()方法");
                Thread.yield();
                System.out.println("当前线程yield结束，ID:" + Thread.currentThread().getId() + "; i:" + i++);
            }
        }
    }
}
