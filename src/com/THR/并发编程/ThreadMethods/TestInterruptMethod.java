package com.THR.并发编程.ThreadMethods;

/**
 * @author Thr
 */
public class TestInterruptMethod {

    private Object object = new Object();
    private int i = 10;


    public static void main(String args[]){
        //testInterruptBlockThread();
        testInterruptNoneBlockThread();
    }


    /**
     * 测试Interrupt被阻塞的线程
     *  程序输出结果如下：
     *       main开始睡眠....
             当前线程ID:9; name:Thread-0
             开始进入睡眠...
             main结束睡眠....
             ----1----
             睡眠被中断
             当前线程结束，ID:9; name:Thread-0
             ----2----
        可见，当调用了 thread.interrupt(); ，thread的阻塞状态被终止，继续向下运行。因此，interrupt()方法能阻断整处于阻塞状态的线程
     */
    public static void testInterruptBlockThread() {
        TestInterruptMethod testInterruptMethod = new TestInterruptMethod();
        MyInterruptBlockTestThread thread = testInterruptMethod.new MyInterruptBlockTestThread();
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + "开始睡眠....");
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束睡眠....");
        } catch (InterruptedException e) {

        }
        System.out.println("----1----");
        thread.interrupt();
        System.out.println("----2----");
    }

    class MyInterruptBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("当前线程ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
                try {
                    System.out.println("开始进入睡眠...");
                    Thread.currentThread().sleep(10000);
                    System.out.println("睡眠结束...");
                } catch (InterruptedException e) {
                    System.out.println("睡眠被中断");
                }
                System.out.println("当前线程结束，ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
            }
        }
    }

    /**
     * 测试Interrupt被阻塞的线程
     *  程序输出结果如下：
     *       main开始睡眠....
             当前线程ID:9; name:Thread-0
             1000000, 2000000, 3000000, 4
             ----1----
             ----2----
             122000000, 123000000, 124000
             当前线程结束，ID:9; name:Thread-0


     可见，当调用了 thread.interrupt(); 子线程的逻辑并没有被中断，还是继续执行循环。因此，interrupt()方法不能能阻断整处于阻塞状态的线程，thread如果不处于阻塞状态则不会被中断，线程继续原有的逻辑执行
        Thread类的方法 isInterrupted() 可以返回线程的中断位，如果线程调用了interrupt()之后，该方法返回true; 因此，当必须使用interrupt()中断非阻断线程时，可以使用 isInterrupted()方法辅助进行中断
        同样可以设置一个变量，线程提供外部修改该变量的方法，在线程内部根据该变量确定是否进行继续执行线程
     */
    public static void testInterruptNoneBlockThread() {
        TestInterruptMethod testInterruptNoneMethod = new TestInterruptMethod();
        MyInterruptNoneBlockTestThread thread = testInterruptNoneMethod.new MyInterruptNoneBlockTestThread();
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + "开始睡眠....");
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束睡眠....");
        } catch (InterruptedException e) {

        }
        System.out.println("----1----");
        thread.interrupt();
        System.out.println("----2----");
    }

    class MyInterruptNoneBlockTestThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("当前线程ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
                int i = 0;
                while (i < 390000000) {
                //while (!isInterrupted() && i < 390000000) {
                    if ((++i) % 1000000 == 0) {
                        System.out.print(i + ", ");
                    }
                    if (i % 1000000000 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println("当前线程结束，ID:" + Thread.currentThread().getId() + "; name:" + Thread.currentThread().getName());
            }
        }
    }
}
