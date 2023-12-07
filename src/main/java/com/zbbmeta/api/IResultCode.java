package com.zbbmeta.api;

/**
 * 统一返回结果
 */
public interface IResultCode {

    /**
     * 返回码
     *
     * @return int
     */
    int getCode();

    /**
     * 返回消息
     *
     * @return String
     */
    String getMessage();

    //操作是否成功
    boolean getSuccess();

}
