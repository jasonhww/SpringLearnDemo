package org.hww.aop.notemethod.beans;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Father4 {

    @Before(value = "execution(* org.hww.aop.notemethod.beans.Person4.*(..))")
    public void before1() {
        System.out.println("前置增强..............");
    }

    @After(value = "execution(* org.hww.aop.notemethod.beans.Person4.*(..))")
    public void after1() {
        System.out.println("后置增强...............");
    }

    //环绕通知
    @Around(value = "execution(* org.hww.aop.notemethod.beans.Person4.*(..))")
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法之前................");
        proceedingJoinPoint.proceed();
        System.out.println("方法之后.................");
    }
}
