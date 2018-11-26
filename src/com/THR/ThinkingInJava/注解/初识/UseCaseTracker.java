package com.THR.ThinkingInJava.注解.初识;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UserCase uc = m.getAnnotation(UserCase.class);
            if (uc != null) {
                System.out.println("获取到注解：" + uc.id() + " , " + uc.description());
            }
        }
    }
    public static void trackUseCases(Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UserCase uc = m.getAnnotation(UserCase.class);
            Annotation[] an = m.getAnnotations();
            uc = (UserCase) an[0];
            if (uc != null) {
                System.out.println("获取到注解：" + uc.id() + " , " + uc.description());
            }
        }
    }

    public static void main(String args[]){
        List<Integer> useCases = new ArrayList<>();
        useCases.add(10);
        useCases.add(15);
        useCases.add(18);
        trackUseCases(useCases, Passwordtils.class);
        trackUseCases(Passwordtils.class);
    }
}
