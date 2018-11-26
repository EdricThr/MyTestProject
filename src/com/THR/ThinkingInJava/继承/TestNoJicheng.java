package com.THR.ThinkingInJava.继承;

/**
 * 用于测试final类和private构造器类不能被继承
 */
public class TestNoJicheng {

}
class Person {
    private Person() {
        
    }
}
final class Person2 {
}

/**
 * 只带有private构造器的类不能被继承
 *  应该是因为子类找不到任意一个构造器
 */
//class Student extends Person {
//
//}
/**
 * final类不能被继承
 */
//class Student extends Person2 {
//
//}
