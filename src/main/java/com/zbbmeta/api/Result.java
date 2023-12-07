package com.zbbmeta.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private boolean success;//是否成功
    private Integer code;//返回码
    private String message;//返回信息
    private T data;//返回数据

    public Result(ResultCode code) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
    }

    public Result(ResultCode code, T data) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }

    public Result(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? SUCCESS() : FAIL();
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> SUCCESS(T data){
        return new Result(ResultCode.SUCCESS,data);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }

    public  static Result FAIL(ResultCode resultCode) {
        return new Result(resultCode.getCode(),resultCode.getMessage(),false);
    }
}
