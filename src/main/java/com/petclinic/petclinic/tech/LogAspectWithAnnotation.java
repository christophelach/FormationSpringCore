package com.petclinic.petclinic.tech;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

@Configuration
@Aspect
@Slf4j
public class LogAspectWithAnnotation {

    @Around("@annotation(MyCustomAnnotation)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        String logMessage = "Starting method: " + joinPoint.getSignature().toShortString();
        stopWatch.start();
        log.info(logMessage);
        try {
            var result = joinPoint.proceed();
            stopWatch.stop();
            var completedTime = stopWatch.getTotalTime(TimeUnit.MICROSECONDS);
            logMessage = "Completed method: " + joinPoint.getSignature().toShortString() + " in " + completedTime + " us";
            log.info(logMessage);
            return result;
        } catch (Throwable throwable) {
            log.error("There was an error !");
            throw throwable;
        }
    }
}
