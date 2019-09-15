package org.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    @Pointcut("execution(* org.spring.aop.Performance.perform(..))")
    public void performance() {
    }

    @Pointcut("execution(* org.spring.aop.Performance.performArgs(int))&&args(name)")
    public void performanceArgs(int name) {
    }

    @Pointcut("@annotation(org.spring.aop.MineLog)")
    public void performanceAnnotation() {
    }

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
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("performance()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before");
        joinPoint.proceed();
        System.out.println("Around After");
    }

    @Around("performanceArgs(name)")
    public void aroundArgs(ProceedingJoinPoint joinPoint, int name) throws Throwable {
        System.out.println("around before arg");
        Object[] os = new Object[1];
        os[0] = name;
        joinPoint.proceed(os);
        System.out.println("around after arg");
    }

    @Before("performanceArgs(name)")
    public void aroundArgs(int name) {
        System.out.println("Before arg");
    }

    @Before("performanceAnnotation()")
    public void beforeAnnotation() {
        System.out.println("before performanceAnnotation");
    }
}
