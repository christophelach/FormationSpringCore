package com.petclinic.petclinic.tech;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class LogAspect {

    @Before("execution(* com.petclinic.petclinic..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String logMessage = "Starting method with before Advice: " + joinPoint.getSignature().toShortString();
        log.info(logMessage);
    }
}
