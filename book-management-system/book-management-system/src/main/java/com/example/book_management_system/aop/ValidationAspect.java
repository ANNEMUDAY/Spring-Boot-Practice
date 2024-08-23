package com.example.book_management_system.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {


    public static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);
    @Before("execution (* com.example.book_management_system.controller.BookController.*(..)) && args(id)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,Long id) throws Throwable {
        if (id<0) {
            LOGGER.info("id is negative, updating it");

            id=-id;
            LOGGER.info("new Value "+id);
        }else{
            LOGGER.info("id is positive and correct");
        }

        Object obj=jp.proceed(new Object[] {id});



        return obj;
    }
}
