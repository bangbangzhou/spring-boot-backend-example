package com.zbbmeta.api;


public enum ResultCode  implements IResultCode{

    SUCCESS(true,10000,"操作成功！"),
    //---系统错误返回码-----
    FAIL(false,10001,"操作失败"),
    UNAUTHENTICATED(false,10002,"您还未登录"),
    UNAUTHORISE(false,10003,"权限不足"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    USER_ERROR(false,10003,"抱歉，用户已存在！"),
    PASSWORD_ERROR(false,10003,"密码错误！"),
    USERNOEXIT_ERROR(false,10003,"用户不存在！"),


    //---用户操作返回码  2xxxx----
    //---用户操作返回码  2xxxx----
    MOBILEORPASSWORDERROR(false,20001,"用户名或密码错误");
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }


    @Override
    public boolean getSuccess() {
        return success;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }



}
