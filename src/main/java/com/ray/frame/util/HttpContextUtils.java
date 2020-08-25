package com.ray.frame.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * HttpContextUtils
 *
 * @author xuel
 * @create 2020/8/25 10:41
 * @since 0.0.1
 */
public class HttpContextUtils {

    private HttpContextUtils() {
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
