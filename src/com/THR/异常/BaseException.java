package com.THR.“Ï≥£;

/**
 * @author Thr
 */
public class BaseException extends RuntimeException {
    private String code = "500";
    public BaseException(String msg, String code, Throwable t) {
        super(msg, t);
        this.code = code;
    }
    public BaseException(String msg, String code) {
        super(msg);
        this.code = code;
    }
    public BaseException(String msg) {
        super(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
