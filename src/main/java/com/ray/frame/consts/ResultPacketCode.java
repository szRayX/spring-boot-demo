package com.ray.frame.consts;

/**
 * ResultPacketCode
 *
 * @author xuel
 * @create 2020/8/25 11:21
 * @since 0.0.1
 */
public class ResultPacketCode {
    public ResultPacketCode() {
    }

    public static enum APIResultCode {
        Fail(100),
        AuthFail(150),
        AuthWarning(151),
        Success(200),
        SystemError(300);

        private Integer code;

        private APIResultCode(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return this.code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    public static enum ResultCode {
        UnkownError(0),
        Success(1),
        NotLogin(1001),
        ParamError(2002);

        private Integer code;

        private ResultCode(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return this.code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }
}
