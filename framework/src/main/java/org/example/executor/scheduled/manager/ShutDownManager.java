package org.example.executor.scheduled.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ShutDownManager {

    @PreDestroy
    public void destroy() {
        shutdownAsyncManager();
    }

    private void shutdownAsyncManager() {
//        try {
//            log.info("====关闭后台任务任务线程池====");
//            AsyncManager.me().shutDown();
//        }
//        catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
    }
}
