package com.ray.frame.exception;

import com.ray.frame.base.BaseResult;
import com.ray.frame.consts.ResultPacketCode.APIResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ControllerExceptionHandler
 *
 * @author xuel
 * @create 2020/8/27 11:25
 * @since 0.0.1
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistsException(BaseException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("message", e.getMessage());
        return map;
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResult handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        BaseResult result = new BaseResult();
        result.setCode(APIResultCode.SystemError.getCode());
        result.setMessage("系统操作失败");
        logger.error("GlobalExceptionHandler→RuntimeException:", ex);
        return result;
    }
}
