package com.ray.frame.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * InterceptorConfig
 *
 * @author xuel
 * @create 2020/8/27 14:11
 * @since 0.0.1
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Resource
    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }
}
