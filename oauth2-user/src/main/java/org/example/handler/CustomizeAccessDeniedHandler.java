package org.example.handler;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.model.R;
import org.example.util.ServletUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * @param request that resulted in an <code>AccessDeniedException</code>
     * @param response so that the user agent can be advised of the failure
     * @param accessDeniedException that caused the invocation
     * @throws IOException io exception
     * @throws ServletException servlet exception
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("请求访问：{}，授权失败，无法访问系统资源", request.getRequestURI());
        log.error("error: {}", accessDeniedException.getMessage());
        ServletUtils.render(response, JSON.toJSONString(new R<String>().fail(accessDeniedException.getMessage())));
    }
}
