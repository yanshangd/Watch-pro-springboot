package com.yanshang.watchpro.utils;

public class Result {
    private Object data;
    private Integer code;
    private String type;

    public Result(Integer code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code, Object data, String type) {
        this.data = data;
        this.code = code;
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", type='" + type + '\'' +
                '}';
    }
}
