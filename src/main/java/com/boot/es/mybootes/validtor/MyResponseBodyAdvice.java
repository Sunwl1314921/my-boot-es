package com.boot.es.mybootes.validtor;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * 拦截请求的方法
 *
 * 处理返回值
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //获取当前处理请求的controller的方法
        String methodName = methodParameter.getMethod().getName();
        // 不拦截/不需要处理返回值 的方法
        String method = "login"; //如登录
        //不拦截
        return !method.equals(methodName);
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //通过 ServerHttpRequest的实现类ServletServerHttpRequest 获得HttpServletRequest
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) serverHttpRequest;
        //此处获取到request 是为了取到在拦截器里面设置的一个对象
        HttpServletRequest request = sshr.getServletRequest();

        //obj是获取请求方法返回的数据
        return obj;
    }
}
