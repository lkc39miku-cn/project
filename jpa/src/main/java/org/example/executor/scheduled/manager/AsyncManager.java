package org.example.executor.scheduled.manager;

import org.springframework.stereotype.Component;

@Component
public class AsyncManager {
//    @Value("${async-manager.operate-delay-time}")
    private Integer OPERATE_DELAY_TIME = 10;
//    private final ScheduledExecutorService scheduledExecutorService = SpringUtils.getBean("scheduledExecutorService");
//    private static final AsyncManager ME = new AsyncManager();
//    public static AsyncManager me() {
//        return ME;
//    }
//
//    public void execute(TimerTask timerTask) {
//        scheduledExecutorService.schedule(timerTask, OPERATE_DELAY_TIME, TimeUnit.SECONDS);
//    }
//    public void shutDown() {
//        ThreadPoolUtils.shutdownAndAwaitTermination(scheduledExecutorService);
//    }
}