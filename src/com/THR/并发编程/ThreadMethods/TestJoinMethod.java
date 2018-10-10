package com.THR.并发编程.ThreadMethods;

/**
 * 用于测试线程调用join()阻塞时对象锁的释放情况
 *
 * @author Thr
 */
public class TestJoinMethod {

    private int i = 10;
    private Object object = new Object();


    public static void main(String args[]){
        try {
            doTestJoinMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过现象可以看出来：
     *  1. 当在主线程调用了子线程的join()方法时, 下面的逻辑不会继续执行
     *  2. join(millis1) 和 线程sleep(millis2)时间的比较
     *      1. > 线程执行完成则继续下面的逻辑
     *      2. < millis1后，开始继续下面的逻辑执行
     *可见：
     *  当线程调用了A.join()或join(millis)后，当且仅当A执行完毕或millis时间后，才会调用执行了join方法下的逻辑（不会对其它线程产生影响，谁直接调用的别人的，谁遭殃）
     * @throws InterruptedException
     */
    public static void doTestJoinMethod() throws InterruptedException {
        TestJoinMethod testBlockObjectStatus = new TestJoinMethod();
        MyJoinBlockTestThread myJoinBlockTestThread1 = testBlockObjectStatus.new MyJoinBlockTestThread();
        System.out.println("----------线程1 start-------------");
        myJoinBlockTestThread1.start();
        System.out.println("----------线程1 join开始-------------");
        myJoinBlockTestThread1.join(15000);
        System.out.println("----------线程1 join结束-------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        System.out.println("------------");
        MyJoinBlockTestThread myJoinBlockTestThread2 = testBlockObjectStatus.new MyJoinBlockTestThread();
        System.out.println("----------线程内 ， 线程2 start-------------");
        myJoinBlockTestThread2.start();
        myJoinBlockTestThread2.join();
        System.out.println("----------线程内 ， 线程2 end-------------");
    }

    class MyJoinBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("当前线程ID:" + Thread.currentThread().getId() + "; i:" + i++ + ",name：" + Thread.currentThread().getName());
                try {
                    System.out.println("-----" + Thread.currentThread().getName() +"进入睡眠------");
                    Thread.currentThread().sleep(40000);
                    System.out.println("-----" + Thread.currentThread().getName() +"结束睡眠------");
                } catch (InterruptedException e) {
                }
                System.out.println("当前线程ID运行结束:" + Thread.currentThread().getId() + "; i:" + i++ + ",name：" + Thread.currentThread().getName());
            }
        }
    }


}
