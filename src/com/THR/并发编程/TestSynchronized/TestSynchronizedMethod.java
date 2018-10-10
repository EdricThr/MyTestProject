package com.THR.并发编程.TestSynchronized;

/**
 * 测试 Synchrozied 在方法上的作用
 *
 * @author Thr
 */
public class TestSynchronizedMethod {

    public static void main(String args[]){
        //testNS();
        //testS();
        //testOS();
        testOStaticS();
    }

    /**
     * 程序运行结果如下：
     ------------------
     Thread-0执行， i: 0
     Thread-1执行， i: 0
     Thread-0执行， i: 1
     Thread-1执行， i: 1
     Thread-0执行， i: 2
     Thread-1执行， i: 2
     Thread-0执行， i: 3
     Thread-1执行， i: 3
     Thread-0执行， i: 4
     Thread-1执行， i: 4

     可见，两个线程交叉调用线程的同一个方法

     */
    public static void testNS() {
        TestSynchronizedMethod testSynchronizedMethod = new TestSynchronizedMethod();
        final NSMethodClass nSMethodClass = testSynchronizedMethod.new NSMethodClass();
        new Thread() {
            @Override
            public void run() {
                nSMethodClass.doInsert();
            }
        }.start();

        System.out.println("------------------");

        new Thread() {
            @Override
            public void run() {
                nSMethodClass.doInsert();
            }
        }.start();
    }

    /**
     * 程序运行结果如下：
         ------------------
         Thread-1执行， i: 0
         Thread-1执行， i: 1
         Thread-1执行， i: 2
         Thread-1执行， i: 3
         Thread-1执行， i: 4
         Thread-0执行， i: 0
         Thread-0执行， i: 1
         Thread-0执行， i: 2
         Thread-0执行， i: 3
         Thread-0执行， i: 4

     可见：在方法上使用了Synchronized关键字之后，线程执行完成本方法之后另一个线程才会执行该方法，方法被上锁（上锁是针对具体一个对象的具体方法来说的）。
     须知：
        1. 当一个线程正在访问一个对象的synchronized方法，那么其他线程不能访问该对象的其他synchronized方法。
     总之：方法同步时对应于某个特定对象的特定方法来说的，当一个线程正在访问一个同步方法时，其它线程不可访问该对象的所有上锁方法，但是能访问该对象的其它未上锁方法，也能访问其它同类型对象的该方法（如果未正被访问）
     */
    public static void testS() {
        TestSynchronizedMethod testSynchronizedMethod = new TestSynchronizedMethod();
        final SMethodClass sMethodClass = testSynchronizedMethod.new SMethodClass();
        new Thread() {
            @Override
            public void run() {
                sMethodClass.doInsert();
            }
        }.start();

        System.out.println("------------------");

        new Thread() {
            @Override
            public void run() {
                sMethodClass.doInsert();
            }
        }.start();
    }


    /**
     *
     * 运行现象如下：
     *      当OSMethodClass的doUpdate()方法被上锁时，两个线程对同一个对象不同方法的访问也不能同时进行，现象类似于访问同一个上锁的方法；
     *      当OSMethodClass的doUpdate()方法未被上锁时，两个线程能够同时访问同一个对象的一个上锁方法和其它非上锁方法
     可见：
         1. 如果一个线程A需要访问对象object1的synchronized方法fun1，另外一个线程B需要访问对象object2的synchronized方法fun1，即使object1和object2是同一类型），也不会产生线程安全问题，因为他们访问的是不同的对象，所以不存在互斥问题。

         2. 当一个线程正在访问一个对象的synchronized方法，那么其他线程能同步访问该对象的非synchronized方法；但是不能同步访问该对象的其它synchronized方法。
            可以理解为：对象的方法被上锁，相当于该对象和锁相关的都被上锁，而非锁相关的不受影响（一个对象有一个锁，被占就不能用锁）
     */
    public static void testOS() {
        TestSynchronizedMethod testSynchronizedMethod = new TestSynchronizedMethod();
        final OSMethodClass osMethodClass = testSynchronizedMethod.new OSMethodClass();
        final OSMethodClass osMethodClass2 = testSynchronizedMethod.new OSMethodClass();
        new Thread() {
            @Override
            public void run() {
                osMethodClass.doInsert();
            }
        }.start();

        System.out.println("------------------");

        new Thread() {
            @Override
            public void run() {
                //osMethodClass2.doInsert();
                osMethodClass.doUpdate();
            }
        }.start();
    }

    /**
     * 当 Synchronized 前被static修饰时，相当于类锁，非static相当于对象锁
     * 1. 此时，如果同时两个线程访问同一个对象的一个static Synchronized 和 非static Synchronized方法，则不会发生互斥
     * 2. 如果两个线程访问不同对象的static Synchronized方法，会发生互斥
     */
    public static void testOStaticS() {
        final OStaticSMethodClass osMethodClass = new OStaticSMethodClass();
        final OStaticSMethodClass osMethodClass2 = new OStaticSMethodClass();
        new Thread() {
            @Override
            public void run() {
                osMethodClass.doInsert();
            }
        }.start();

        System.out.println("------------------");

        new Thread() {
            @Override
            public void run() {
                //osMethodClass.doUpdate();
                osMethodClass2.doInsert();
            }
        }.start();
    }


    class NSMethodClass {
        public void doInsert() {
            int i = 0;
            while (i < 5) {
                System.out.println(Thread.currentThread().getName() + "执行， i: " +i++ );
            }
        }
    }


    class SMethodClass {
        public synchronized void doInsert() {
            int i = 0;
            while (i < 5) {
                System.out.println(Thread.currentThread().getName() + "执行， i: " +i++ );
            }
        }
    }

    class OSMethodClass {
        public synchronized void doInsert() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "执行doInsert()， i: " + i++ );
            }
        }
        public synchronized void doUpdate() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "执行doUpdate()， i: " + i++ );
            }
        }
    }
    static class OStaticSMethodClass {
        public static synchronized void doInsert() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "执行doInsert()， i: " + i++ );
            }
        }
        public synchronized void doUpdate() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "执行doUpdate()， i: " + i++ );
            }
        }
    }
}
