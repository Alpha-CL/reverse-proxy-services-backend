package com.example.services.controller;


/**
 * 通用返回结果封装类
 */
public class Resp<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    protected Resp() {
    }

    protected Resp(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static Resp<Void> success() {
        return new Resp<Void>(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Resp<T> success(T data) {
        return new Resp<T>(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Resp<T> success(T data, String message) {
        return new Resp<T>(RespCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Resp<T> failed(IErrorCode errorCode) {
        return new Resp<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> Resp<T> failed(IErrorCode errorCode, String message) {
        return new Resp<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Resp<T> failed(String message) {
        return new Resp<T>(RespCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> Resp<T> failed() {
        return failed(RespCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Resp<T> validateFailed() {
        return failed(RespCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Resp<T> validateFailed(String message) {
        return new Resp<T>(RespCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Resp<T> unauthorized(T data) {
        return new Resp<T>(RespCode.UNAUTHORIZED.getCode(), RespCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Resp<T> forbidden(T data) {
        return new Resp<T>(RespCode.FORBIDDEN.getCode(), RespCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
