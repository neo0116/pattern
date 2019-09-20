package com.ByteDance.strategy.orderStrategy;

/**
 * @ClassName PayResult
 * @Description TODO
 * @Version 1.0
 **/
public class PayResult<T> {

    private int code;

    private String msg;

    private T data;

    public PayResult() {
    }

    public PayResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PayResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
