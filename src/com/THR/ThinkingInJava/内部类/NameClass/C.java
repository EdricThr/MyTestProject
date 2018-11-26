package com.THR.ThinkingInJava.内部类.NameClass;

public class C {
    public class D{//可以看到，在public class内部，可以定义public class

    }
    public static void main(String args[]){
        System.out.println("C..........");
    }
}
class A {
    public class D{//可以看到，在class内部，可以定义public class

    }
    public static void main(String args[]){
        System.out.println("A............");
    }
}
/*public class B {//提示如下：class B is public, should be delcared in a file named B.java

}*/
