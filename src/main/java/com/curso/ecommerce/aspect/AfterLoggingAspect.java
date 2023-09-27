package com.curso.ecommerce.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterLoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@After("execution(* com.curso.ecommerce.controller..*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("After--->Después de llamar al método: " + joinPoint.getSignature().getName());
	}
}
