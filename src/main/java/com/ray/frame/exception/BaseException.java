package com.ray.frame.exception;

import com.ray.frame.consts.ResultPacketCode.APIResultCode;

/**
 * BaseException
 *
 * @author xuel
 * @create 2020/8/25 11:21
 * @since 0.0.1
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
        this.code = APIResultCode.Fail.getCode();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
