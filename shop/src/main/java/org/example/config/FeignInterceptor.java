package org.example.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.example.util.ServletUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Configuration
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (RequestContextHolder.getRequestAttributes() != null) {
            if (StringUtils.isNotEmpty(ServletUtils.getParameter("page")) && StringUtils.isNotEmpty(ServletUtils.getParameter("pageSize"))) {
                requestTemplate.header("page", ServletUtils.getParameter("page"));
                requestTemplate.header("pageSize", ServletUtils.getParameter("pageSize"));
            }
        }
    }
}
