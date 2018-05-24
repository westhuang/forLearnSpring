package com.west.forlearn.comm;

// 返回数据统一封装
public class RespEntity {

    private int code;
    private String msg;
    private Object data;

    public RespEntity(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public RespEntity(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
