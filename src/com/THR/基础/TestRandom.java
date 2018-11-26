package com.THR.����;

import java.util.Random;

/**
 * ѧϰjava����������ļ��ַ�ʽ����ͬ
 */
public class TestRandom {

    public static void main(String args[]){

        doRandom();
        //����������֮���Ժ���������������ǰһ��������йأ�����Ϊ���������������һ�£����£�
        doRandom(10);
        doRandom(10);
        doRandom(10);
        doRandom(10);

        doMathRandom();
    }

    /**
     * ����������Random
     * Random���л��ṩ��������������ķ�����
         nextInt()������һ���������(int)
         nextInt(int n)�����ش��ڵ���0��С��n���������(int)
         nextLong()������һ�����������ֵ(long)
         nextBoolean()������һ�����������ֵ(boolean)
         nextFloat()������һ�����������ֵ(float)
         nextDouble()������һ�����˫������ֵ(double)
         nextGaussian()�������ܶ�Ϊ��˹�ֲ���˫����ֵ(double)
     */
    public static void doRandom() {
        Random random = new Random();

        //random.nextInt(n);������[0, n)֮��������������ʵҲ����[0, n-1]
        System.out.println(random.nextInt(100));
        //���������[1, 100]
        System.out.println(random.nextInt(100) + 1);
        //�����������λ����
        System.out.println(random.nextInt(90) + 10);
        //ͬ�������������λ����
        System.out.println(random.nextInt(200) + 100);
    }

    /**
     * ���Դ�����Random
     *  ������Random���Ժ���������������ǰһ��������йأ�����Ϊ���������������һ��
     * @param seed ����
     */
    public static void doRandom(int seed) {
        Random random = new Random(seed);
        //����ʹ������ķ�ʽ
        //Random random1 = new Random();
        //random1.setSeed(seed);
        for (int i = 0; i < 20; i++) {
            System.out.print(random.nextInt(20) + ",");
        }
        System.out.println();
    }

    /**
     * Math.random()
     * ����[0.0d, 1.0d)��double���������
     * 1. ����ͨ��ǿ������ת���õ��������͵������
     *   eg:�����������[0, n)��(int)(Math.random()*n)
     *      ��������ַ�[a, z)��(char)('a' + Math.random() * ('z' - 'a'))
     * 2. ����ͨ��+��-ĳ����ֵ���õ�������Χ�������[m, m+n)
     *   eg:m + (int)(Math.random()*n)
     */
    public static void doMathRandom() {
        System.out.println(Math.random());
        //����[0, n)֮���������(int)(Math.random()*n);
        int i = ((int)(Math.random() * 10));
        System.out.println(i);
        //����[a, z)֮����ַ�
        char c = (char)('a' + Math.random() * ('z' - 'a'));
        System.out.println(c);
        //����[m, n)֮���������m + (int)(Math.random()*n);
        i = ((int)(Math.random() * 10) + 1);
        System.out.println(i);
    }
}
