package com.THR.JVM;

/**
 * 对象回收的两次标记
 */
public class ObjectGCTwice {

    public static ObjectGCTwice SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive...");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        ObjectGCTwice.SAVE_HOOK = this;
    }

    public static void main(String args[]) throws InterruptedException {
        SAVE_HOOK = new ObjectGCTwice();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead...");
        }

        System.out.println("---------------");

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead...");
        }
    }
}
