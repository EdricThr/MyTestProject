package com.THR.DesignPatterns.代理模式.智能引用代理.动态代理.Jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {

    /**
     * 要代理的对象
     */
    private Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy 被代理的对象
     * @param method 被代理的对象的方法
     * @param args 方法的参数
     * @return 返回值，被代理的对象的方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //可以使用通过参数（方法名称、方法签名、方法参数等）控制某些不需要的方法调用
        //if (method.getName().equals("aabbcc")) {
        //    System.out.println("执行额外操作");
        //}

        System.out.println("开始记录汽车行驶的时间");
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        long moveTime = endTime - startTime;
        System.out.println("汽车行驶的时间：" + moveTime);
        System.out.println("结束记录汽车行驶的时间");
        return null;
    }
}
