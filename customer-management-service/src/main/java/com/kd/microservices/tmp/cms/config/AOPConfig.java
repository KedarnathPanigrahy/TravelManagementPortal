package com.kd.microservices.tmp.cms.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AOPConfig {

	@Around("@annotation(Performance)")
	@Order(1)
	public Object performance(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getTarget().getClass().getCanonicalName();
		String methodName = pjp.getSignature().getName();
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Exiting " + className + " - " + methodName + " with execution time (ms) : " + elapsedTime);
		return output;
	}
	
	@Before("execution(* com.kd.microservices.tmp.cms.*.*.*(..))")
	@Order(2)
	public void logging(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getCanonicalName();
		String methodName = joinPoint.getSignature().getName();
		log.info("Starting " + className + " - " + methodName);
	}
	
	@After("execution(* com.kd.microservices.tmp.cms.*.*.*(..))")
	@Order(3)
	public void afterLogging(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getCanonicalName();
		String methodName = joinPoint.getSignature().getName();
		log.info("Exiting from " + className + " - " + methodName);
	}
	
	@AfterThrowing(pointcut = "execution(* com.kd.microservices.tmp.cms.service.*.*(..))", throwing = "exception")
	@Order(4)
	public void exceptionLogger(JoinPoint joinPoint, Throwable exception) throws Throwable {
		String className = joinPoint.getTarget().getClass().getCanonicalName();
		String methodName = joinPoint.getSignature().getName();
		log.info("Exception at " + className + " - " + methodName + " : " + exception.getMessage());
	}
}
