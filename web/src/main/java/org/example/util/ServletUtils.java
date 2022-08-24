package org.example.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtils {

    public static void render(HttpServletResponse response, String str) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(str);
    }
    public static ServletRequestAttributes servletRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    public static HttpServletRequest httpServletRequest() throws NullPointerException {
        return servletRequestAttributes().getRequest();
    }

    public static String getParameter(String name) {
        return httpServletRequest().getParameter(name);
    }
}