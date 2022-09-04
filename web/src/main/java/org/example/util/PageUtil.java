package org.example.util;


import org.example.key.PageKey;

public class PageUtil {

    public static Integer page() {
        int i;
        try {
            i = Integer.parseInt(ServletUtils.getParameter(PageKey.page));
        } catch (Exception e) {
            return Integer.parseInt(ServletUtils.httpServletRequest().getHeader(PageKey.page));
        }
        return i;
    }

    public static Integer pageSize() {
        int i;
        try {
            i = Integer.parseInt(ServletUtils.getParameter(PageKey.pageSize));
        } catch (Exception e) {
            return Integer.parseInt(ServletUtils.httpServletRequest().getHeader(PageKey.pageSize));
        }
        return i;
    }
}
