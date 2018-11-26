package com.THR.基础;

import java.util.Random;

/**
 * 学习java生成随机数的几种方式、异同
 */
public class TestRandom {

    public static void main(String args[]){

        doRandom();
        //设置了种子之后，以后产生的随机数都与前一个随机数有关，表现为产生的随机数序列一致，如下：
        doRandom(10);
        doRandom(10);
        doRandom(10);
        doRandom(10);

        doMathRandom();
    }

    /**
     * 测试无种子Random
     * Random类中还提供各种类型随机数的方法：
         nextInt()：返回一个随机整数(int)
         nextInt(int n)：返回大于等于0、小于n的随机整数(int)
         nextLong()：返回一个随机长整型值(long)
         nextBoolean()：返回一个随机布尔型值(boolean)
         nextFloat()：返回一个随机浮点型值(float)
         nextDouble()：返回一个随机双精度型值(double)
         nextGaussian()：概率密度为高斯分布的双精度值(double)
     */
    public static void doRandom() {
        Random random = new Random();

        //random.nextInt(n);将生成[0, n)之间的随机整数，其实也就是[0, n-1]
        System.out.println(random.nextInt(100));
        //如果想生成[1, 100]
        System.out.println(random.nextInt(100) + 1);
        //如果想生成两位整数
        System.out.println(random.nextInt(90) + 10);
        //同理，如果想生成三位整数
        System.out.println(random.nextInt(200) + 100);
    }

    /**
     * 测试带种子Random
     *  带种子Random：以后产生的随机数都与前一个随机数有关，表现为产生的随机数序列一致
     * @param seed 种子
     */
    public static void doRandom(int seed) {
        Random random = new Random(seed);
        //或者使用下面的方式
        //Random random1 = new Random();
        //random1.setSeed(seed);
        for (int i = 0; i < 20; i++) {
            System.out.print(random.nextInt(20) + ",");
        }
        System.out.println();
    }

    /**
     * Math.random()
     * 产生[0.0d, 1.0d)的double类型随机数
     * 1. 可以通过强制类型转换得到其他类型的随机数
     *   eg:产生随机整数[0, n)：(int)(Math.random()*n)
     *      产生随机字符[a, z)：(char)('a' + Math.random() * ('z' - 'a'))
     * 2. 可以通过+、-某个数值，得到其他范围的随机数[m, m+n)
     *   eg:m + (int)(Math.random()*n)
     */
    public static void doMathRandom() {
        System.out.println(Math.random());
        //产生[0, n)之间的整数：(int)(Math.random()*n);
        int i = ((int)(Math.random() * 10));
        System.out.println(i);
        //产生[a, z)之间的字符
        char c = (char)('a' + Math.random() * ('z' - 'a'));
        System.out.println(c);
        //产生[m, n)之间的整数：m + (int)(Math.random()*n);
        i = ((int)(Math.random() * 10) + 1);
        System.out.println(i);
    }
}
