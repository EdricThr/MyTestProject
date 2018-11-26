package com.THR.线程.异步回调;

public class CallBackTask {

    private CallBackBody callBackBody;

    public CallBackTask(CallBackBody callBackBody) {
        this.callBackBody = callBackBody;
    }

    protected void start(final Object context){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    callBackBody.execute(context);
                }catch (Exception e){
                    e.printStackTrace();
                    callBackBody.onFailure(context);
                }
                callBackBody.onSuccess(context);
            }
        }).start();
    }
}
