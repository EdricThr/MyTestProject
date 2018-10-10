package com.THR.�������.TestSynchronized;

/**
 * ����Synchronized�����ڴ����
 *
 * @author Thr
 */
public class TestSynchronizedBlock {
    /**
     * synObject������this�������ȡ��ǰ���������Ҳ���������е�һ�����ԣ������ȡ�����Ե�����
     *
     * synchronized�����ʹ��������synchronized����Ҫ���öࡣ
     * ��ΪҲ��һ��������ֻ��һ���ִ���ֻ��Ҫͬ���������ʱ������������synchronized����ͬ������Ӱ�����ִ��Ч�ʡ�
     * ��ʹ��synchronized�����Ϳ��Ա���������⣬synchronized��������ʵ��ֻ����Ҫͬ���ĵط�����ͬ����
     * **/

    class SBlockThisClass {
        public void doInsert() {
            synchronized(this) {
                int i = 0;
                while (i < 5) {
                    System.out.println(Thread.currentThread().getName() + "ִ�У� i: " +i++ );
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
                    System.out.println(Thread.currentThread().getName() + "ִ�У� i: " +i++ );
                }
            }
        }
    }

}
