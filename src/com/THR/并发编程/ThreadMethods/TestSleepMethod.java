package com.THR.并发编程.ThreadMethods;

/**
 * @author Thr
 */
public class TestSleepMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        doTestSleepMethod();
    }


    /**
     * 测试Thread.sleep()方法
     * 如果不加锁，程序运行结果如下：
     当前线程ID:9; i:10
     当前线程ID:10; i:11
     线程开始调用sleep()
     线程开始调用sleep()
     当前线程sleep结束，ID:10; i:13
     当前线程sleep结束，ID:9; i:12
     * 如果加锁，程序结果如下：
     当前线程ID:9; i:10
     线程开始调用sleep()
     当前线程sleep结束，ID:9; i:11
     当前线程ID:10; i:12
     线程开始调用sleep()
     当前线程sleep结束，ID:10; i:13

     可以看出：
     1. sleep()方法属于Thread类，且需要对异常进行检查
     2. 线程调用sleep()方法并不会释放对象的锁
     3. 须知：当sleep()时间结束后，线程不一定会立刻执行，当前CPU可能在执行其他的任务
     (调用sleep()方法后，线程进入阻塞(准确说是time waiting)状态，后面还是需要经过就绪状态，不一定会立刻得到CPU时间)
     */
    public static void doTestSleepMethod() {
        TestSleepMethod sleepMethod = new TestSleepMethod();
        sleepMethod.new MySleepBlockTestThread().start();
        sleepMethod.new MySleepBlockTestThread().start();
    }

    class MySleepBlockTestThread extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("当前线程ID:" + Thread.currentThread().getId() + "; i:" + i++);
                try {
                    System.out.println("线程开始调用sleep()");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程sleep结束，ID:" + Thread.currentThread().getId() + "; i:" + i++);
            }
        }
    }
}
