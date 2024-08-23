package com.example.book_management_system.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniterAspect {
    public static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMoniterAspect.class);

    @Around("execution (* com.example.book_management_system.controller.BookController.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start=System.currentTimeMillis();

        Object obj= jp.proceed();
        long end=System.currentTimeMillis();

        LOGGER.info("Time taken by: "+jp.getSignature().getName()+" "+(end-start)+" ms");
        return obj;
    }
}
