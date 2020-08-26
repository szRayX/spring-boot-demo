package com.ray.frame.base;

import com.ray.frame.consts.ResultPacketCode.APIResultCode;

import java.io.Serializable;

/**
 * BaseResult
 *
 * @author xuel
 * @create 2020/8/25 13:54
 * @since 0.0.1
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Integer code;
    protected String message;

    public BaseResult() {
    }

    public BaseResult(Integer code) {
        this.code = code;
        this.message = null;
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseResult fail(String message) {
        return new BaseResult(APIResultCode.Fail.getCode(), message);
    }

    public static BaseResult success() {
        return new BaseResult(APIResultCode.Success.getCode());
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
