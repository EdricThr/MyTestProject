package com.THR.�������.TestSynchronized;

/**
 * ���� Synchrozied �ڷ����ϵ�����
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
     * �������н�����£�
     ------------------
     Thread-0ִ�У� i: 0
     Thread-1ִ�У� i: 0
     Thread-0ִ�У� i: 1
     Thread-1ִ�У� i: 1
     Thread-0ִ�У� i: 2
     Thread-1ִ�У� i: 2
     Thread-0ִ�У� i: 3
     Thread-1ִ�У� i: 3
     Thread-0ִ�У� i: 4
     Thread-1ִ�У� i: 4

     �ɼ��������߳̽�������̵߳�ͬһ������

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
     * �������н�����£�
         ------------------
         Thread-1ִ�У� i: 0
         Thread-1ִ�У� i: 1
         Thread-1ִ�У� i: 2
         Thread-1ִ�У� i: 3
         Thread-1ִ�У� i: 4
         Thread-0ִ�У� i: 0
         Thread-0ִ�У� i: 1
         Thread-0ִ�У� i: 2
         Thread-0ִ�У� i: 3
         Thread-0ִ�У� i: 4

     �ɼ����ڷ�����ʹ����Synchronized�ؼ���֮���߳�ִ����ɱ�����֮����һ���̲߳Ż�ִ�и÷�������������������������Ծ���һ������ľ��巽����˵�ģ���
     ��֪��
        1. ��һ���߳����ڷ���һ�������synchronized��������ô�����̲߳��ܷ��ʸö��������synchronized������
     ��֮������ͬ��ʱ��Ӧ��ĳ���ض�������ض�������˵�ģ���һ���߳����ڷ���һ��ͬ������ʱ�������̲߳��ɷ��ʸö�����������������������ܷ��ʸö��������δ����������Ҳ�ܷ�������ͬ���Ͷ���ĸ÷��������δ�������ʣ�
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
     * �����������£�
     *      ��OSMethodClass��doUpdate()����������ʱ�������̶߳�ͬһ������ͬ�����ķ���Ҳ����ͬʱ���У����������ڷ���ͬһ�������ķ�����
     *      ��OSMethodClass��doUpdate()����δ������ʱ�������߳��ܹ�ͬʱ����ͬһ�������һ��������������������������
     �ɼ���
         1. ���һ���߳�A��Ҫ���ʶ���object1��synchronized����fun1������һ���߳�B��Ҫ���ʶ���object2��synchronized����fun1����ʹobject1��object2��ͬһ���ͣ���Ҳ��������̰߳�ȫ���⣬��Ϊ���Ƿ��ʵ��ǲ�ͬ�Ķ������Բ����ڻ������⡣

         2. ��һ���߳����ڷ���һ�������synchronized��������ô�����߳���ͬ�����ʸö���ķ�synchronized���������ǲ���ͬ�����ʸö��������synchronized������
            �������Ϊ������ķ������������൱�ڸö��������صĶ�����������������صĲ���Ӱ�죨һ��������һ��������ռ�Ͳ���������
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
     * �� Synchronized ǰ��static����ʱ���൱����������static�൱�ڶ�����
     * 1. ��ʱ�����ͬʱ�����̷߳���ͬһ�������һ��static Synchronized �� ��static Synchronized�������򲻻ᷢ������
     * 2. ��������̷߳��ʲ�ͬ�����static Synchronized�������ᷢ������
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
                System.out.println(Thread.currentThread().getName() + "ִ�У� i: " +i++ );
            }
        }
    }


    class SMethodClass {
        public synchronized void doInsert() {
            int i = 0;
            while (i < 5) {
                System.out.println(Thread.currentThread().getName() + "ִ�У� i: " +i++ );
            }
        }
    }

    class OSMethodClass {
        public synchronized void doInsert() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "ִ��doInsert()�� i: " + i++ );
            }
        }
        public synchronized void doUpdate() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "ִ��doUpdate()�� i: " + i++ );
            }
        }
    }
    static class OStaticSMethodClass {
        public static synchronized void doInsert() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "ִ��doInsert()�� i: " + i++ );
            }
        }
        public synchronized void doUpdate() {
            int i = 0;
            while (i < 10) {
                System.out.println(Thread.currentThread().getName() + "ִ��doUpdate()�� i: " + i++ );
            }
        }
    }
}
