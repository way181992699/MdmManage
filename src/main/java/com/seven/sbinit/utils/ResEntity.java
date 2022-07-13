package com.seven.sbinit.utils;

import lombok.Data;

@Data
public class ResEntity<T> {
    public final static int SUCCESS_CODE = 200;
    public final static int ERROR_CODE = 500;
    public static String SUCCESS_MSG = "success";
    public static String FAILED_MSG = "failed";
    private int code;
    private T data;
    private String msg;
    private Long s;

    public ResEntity() {
    }

    public ResEntity(T data) {
        this.data = data;
    }

    public ResEntity(int code, T data) {
        this.code = code;
        this.data = data;
        this.msg = "";
        this.s = System.currentTimeMillis();
    }

    public ResEntity(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.msg = message;
        this.s = System.currentTimeMillis();
    }

    public ResEntity responseSuccess() {
        return new ResEntity(SUCCESS_CODE, "", SUCCESS_MSG);
    }

    public ResEntity responseSuccess(int code, T data) {
        return new ResEntity(code, data, SUCCESS_MSG);
    }

    public ResEntity responseSuccess(T data) {
        return new ResEntity(SUCCESS_CODE, data, SUCCESS_MSG);
    }

    public ResEntity responseError( String message) {
        return new ResEntity(ERROR_CODE, "", message);
    }

}
