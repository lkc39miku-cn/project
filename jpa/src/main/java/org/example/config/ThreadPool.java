package org.example.config;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

//@Configuration
public class ThreadPool {
//    @Value("${thread-pool.core-pool-size}")
    private Integer corePoolSize;
//    @Value("${thread-pool.max-pool-size}")
    private Integer maxPoolSize;
//    @Value("${thread-pool.queue-capacity}")
    private Integer queueCapacity;
//    @Value("${thread-pool.keep-alive-seconds}")
    private Integer keepAliveSeconds;

//    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

//    @Bean(name = "scheduledExecutorService")
    public ScheduledExecutorService scheduledExecutorService() {
        return new ScheduledThreadPoolExecutor(corePoolSize,
                new BasicThreadFactory.Builder()
                        .namingPattern("schedule-pool-%d")
                        .daemon(true)
                        .build(),
                new ThreadPoolExecutor.CallerRunsPolicy()) {
                    @Override
                    protected void afterExecute(Runnable r, Throwable t)
                    {
                        super.afterExecute(r, t);
                        ThreadPoolUtils.printException(r, t);
                    }
                };
    }
}