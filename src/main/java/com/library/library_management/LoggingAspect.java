package com.library.library_management;

//first we imported the aop dependency inside pom.xml then created the @Aspect class , it is @Component

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // الكود ده هيتم تنفيذه قبل أي Method في الـ package com.library.library_management
    // Before Advice
    @Before("execution(* com.library.library_management..*(..))")
    public void logBefore() {
        System.out.println("Method is about to be executed... {@Before} ");
    }

    // After Advice
    @After("execution(* com.library.library_management..*(..))")
    public void logAfter() {
        System.out.println("Method has been executed. {@After}");
    }

    // Around Advice = before the before adivce + after the after advice
    // also more flex
    @Around("execution(* com.library.library_management..*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method execution {@Around}");
        joinPoint.proceed();  // this is where the method will be executed
        System.out.println("After method execution {@Around}");
    }

}

/*
 * Aspect -> the class 'LoggingAspect'
 * Advice -> logBefore()
 * Joinpoint -> execution(* com.library.library_management..*(..))
*/

