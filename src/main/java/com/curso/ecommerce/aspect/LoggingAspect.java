package com.curso.ecommerce.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.curso.ecommerce.controller..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Antes de llamar al método: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.curso.ecommerce.controller..*.*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Después de llamar al método: " + joinPoint.getSignature().getName());
        logger.info("Resultado: " + result);
    }
}
