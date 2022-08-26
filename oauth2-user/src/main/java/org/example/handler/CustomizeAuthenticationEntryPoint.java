package org.example.handler;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.model.R;
import org.example.util.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * @param request that resulted in an <code>AuthenticationException</code>
     * @param response so that the user agent can begin authentication
     * @param authException that caused the invocation
     * @throws IOException io exception
     * @throws ServletException servlet exception
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        log.error("error: {}", authException.getMessage());

        if (Objects.isNull(authException.getCause())) {
            ServletUtils.render(response, JSON.toJSONString(new R<String>().fail("认证失败")));
        }
        ServletUtils.render(response, JSON.toJSONString(new R<String>().fail(authException.getCause().getMessage())));
    }
}
