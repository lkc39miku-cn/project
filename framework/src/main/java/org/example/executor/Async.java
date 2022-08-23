package org.example.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@Slf4j
public class Async implements AsyncConfigurer {

//    @Value("${thread-pool.core-pool-size}")
//    private Integer corePoolSize;
//    @Value("${thread-pool.max-pool-size}")
//    private Integer maxPoolSize;
//    @Value("${thread-pool.queue-capacity}")
//    private Integer queueCapacity;
//    @Value("${thread-pool.keep-alive-seconds}")
//    private Integer keepAliveSeconds;
//
//    @Value("${thread-pool.executor.async.name.prefix}")
//    private String prefix;
//
//
//    @Bean(name = "asyncServiceExecutor")
//    public Executor asyncServiceExecutor() {
//        log.info("asyncServiceExecutor start");
//
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//
//        executor.setCorePoolSize(corePoolSize);
//        executor.setMaxPoolSize(maxPoolSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setKeepAliveSeconds(keepAliveSeconds);
//        executor.setThreadNamePrefix(prefix);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.initialize();
//
//        return executor;
//    }
//
//    @Override
//    public Executor getAsyncExecutor() {
//        return asyncServiceExecutor();
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return (ex, method, params) -> log.error(String.format("asyncServiceExecutor start do executor'%s'", method), ex);
//    }
}
