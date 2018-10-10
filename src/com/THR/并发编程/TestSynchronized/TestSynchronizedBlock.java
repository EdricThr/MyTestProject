package com.THR.并发编程.TestSynchronized;

/**
 * 测试Synchronized作用于代码块
 *
 * @author Thr
 */
public class TestSynchronizedBlock {
    /**
     * synObject可以是this，代表获取当前对象的锁，也可以是类中的一个属性，代表获取该属性的锁。
     *
     * synchronized代码块使用起来比synchronized方法要灵活得多。
     * 因为也许一个方法中只有一部分代码只需要同步，如果此时对整个方法用synchronized进行同步，会影响程序执行效率。
     * 而使用synchronized代码块就可以避免这个问题，synchronized代码块可以实现只对需要同步的地方进行同步。
     * **/

    class SBlockThisClass {
        public void doInsert() {
            synchronized(this) {
                int i = 0;
                while (i < 5) {
                    System.out.println(Thread.currentThread().getName() + "执行， i: " +i++ );
                }
            }
        }
    }
    class SBlockObjectClass {
        private Object object = new Object();
        public void doInsert() {
            synchronized(object) {
                int i = 0;
                while (i < 5) {
                    System.out.println(Thread.currentThread().getName() + "执行， i: " +i++ );
                }
            }
        }
    }

}
