package uvt.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {
    private final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Before("execution(* uvt.controllers.BookController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before: " + joinPoint);
    }

    @After("execution(* uvt.controllers.BookController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After: " + joinPoint);
    }
}
