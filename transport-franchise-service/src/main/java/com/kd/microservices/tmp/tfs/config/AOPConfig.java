package com.kd.microservices.tmp.tfs.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AOPConfig {

    @Pointcut("execution(* *(..)) &&" +
            "    within(com.kd.microservices.tmp.tfs.controller..*) ||" +
            "    within(com.kd.microservices.tmp.tfs.service..*)" +
            ")")
    protected void loggingOperation() {
    }

    @Around("loggingOperation()")
    @Order(1)
    public Object aroundMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getCanonicalName();
        String methodName = pjp.getSignature().getName();
        log.info("Starting " + className + " - " + methodName);
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Exiting " + className + " - " + methodName + " with execution time (ms) : " + elapsedTime);
        return output;
    }

    @AfterThrowing(pointcut = "loggingOperation()", throwing = "e")
    @Order(2)
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + "()");
        log.error("Cause :" + e.getCause());
    }

}
