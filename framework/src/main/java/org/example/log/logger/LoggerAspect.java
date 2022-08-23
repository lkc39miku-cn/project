package org.example.log.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    @AfterReturning(pointcut = "@annotation(logger)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Logger logger, Object result) {
        // TODO
    }

    @AfterThrowing(value = "@annotation(logger)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Logger logger, Exception e) {
        // TODO
    }
}
