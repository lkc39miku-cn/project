package org.example.util;


import org.example.key.PageKey;

public class PageUtil {

    public static Integer page() {
        return Integer.parseInt(ServletUtils.getParameter(PageKey.page));
    }

    public static Integer pageSize() {
        return Integer.parseInt(ServletUtils.getParameter(PageKey.pageSize));
    }
}
