package org.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* org.spring.aop.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void before1() {
        System.out.println("Before1");
    }

    @Before("performance()")
    public void before2() {
        System.out.println("Before2");
    }

    @After("performance()")
    public void after() {
        System.out.println("After");
    }

    @AfterReturning("performance()")
    public void afterReturning() {
        System.out.println("AfterReturning");
    }

    @AfterThrowing("performance()")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }

    /**
     * Around是在proceed()方法调用前后各执行一次
     * @param joinPoint
     * @throws Throwable
     */
    @Around("performance()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before");
        joinPoint.proceed();
        System.out.println("Around After");
    }

}
