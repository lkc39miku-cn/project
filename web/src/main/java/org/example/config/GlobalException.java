package org.example.config;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.constants.CodeEnum;
import org.example.exception.service.ServiceException;
import org.example.model.R;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public final class GlobalException {
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public <T> R<T> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String uri = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", uri, e.getMethod());
        return new R<T>().fail("请求地址'" + uri + "', 不支持'" + e.getMethod() + "'请求");
    }

    @ExceptionHandler(value = {ServiceException.class})
    public R<String> handleServiceException (ServiceException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return new R<String>().fail(e.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public <T> R<T> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new R<T>().fail(e.getMessage());
    }
}
