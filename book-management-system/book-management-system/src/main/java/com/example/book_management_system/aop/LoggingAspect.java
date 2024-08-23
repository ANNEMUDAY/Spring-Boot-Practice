package com.example.book_management_system.aop;

import jakarta.persistence.criteria.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution (* com.example.book_management_system.controller.BookController.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Hello Uday calling methods");
        LOGGER.info("Method Called Before "+jp.getSignature().getName());
       // System.out.println("Method Called ");
    }
    @After("execution (* com.example.book_management_system.controller.BookController.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed After "+jp.getSignature().getName());
    }
    @AfterThrowing("execution (* com.example.book_management_system.controller.BookController.*(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method has some issues "+jp.getSignature().getName());
    }
    @AfterReturning("execution (* com.example.book_management_system.controller.BookController.*(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }
}