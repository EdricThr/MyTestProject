package com.THR.�߳�.�첽�ص�;

public abstract class CallBackBody {

    void onSuccess(Object context){
        System.out.println("onSuccess");
    }

    void onFailure(Object context){
        System.out.println("OnFailure");
    }
    abstract void execute(Object context);
}
