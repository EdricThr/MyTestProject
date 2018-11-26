package com.THR.ThinkingInJava.∂‡Ã¨;

public class TestDontaiBangDing {


    public static void main(String args[]){
        doThing1(new People());
        doThing1(new Father());
        doThing1(new Son());
        final Father father = new Father();

    }

    public static void doThing1(People people) {
    }
    public static void doThing1(final Father father) {
        yyy yy = new yyy(father) {
            @Override
            void test() {
                System.out.println(father);
            }
        };
    }
    public static void doThing1() {
        final String username = "";
        class uuu{
            void pp() {
                System.out.println(username);
            }
        }

    }
    static abstract class yyy{
        yyy(Father father){

        }
        abstract void test();
    }
}
