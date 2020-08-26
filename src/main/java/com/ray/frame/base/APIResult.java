package com.ray.frame.base;

import com.ray.frame.consts.ResultPacketCode.APIResultCode;

/**
 * APIResult
 *
 * @author xuel
 * @create 2020/8/25 13:55
 * @since 0.0.1
 */
public class APIResult<T> extends BaseResult {
    private T result;

    public APIResult() {
    }

    public APIResult(Integer code) {
        super.code = code;
        super.message = null;
    }

    public APIResult(Integer code, String message) {
        super.code = code;
        super.message = message;
    }

    public static APIResult fail(String message) {
        return new APIResult(APIResultCode.Fail.getCode(), message);
    }

    public static APIResult success() {
        return new APIResult(APIResultCode.Success.getCode());
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
