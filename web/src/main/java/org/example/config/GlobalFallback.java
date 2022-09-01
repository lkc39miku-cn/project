package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.model.R;

@Slf4j
public class GlobalFallback {
    public static <T> R<T> handleException(Throwable e) {
        log.error(e.getMessage(), e);
        return new R<T>().fail(e.getMessage());
    }
}
