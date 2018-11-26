package com.THR.EffectiveJava.Cap_5_AvoidCreateNewObject;

public final class FinalClass {
    private static FinalClass finalClass;
    private FinalClass() {}
    public static FinalClass getInstance() {
        if (null == finalClass) {
            finalClass = new FinalClass();
        }
        return finalClass;
    }
}