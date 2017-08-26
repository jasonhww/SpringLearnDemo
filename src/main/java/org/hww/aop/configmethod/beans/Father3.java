package org.hww.aop.configmethod.beans;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class Father3 {

    public void before1() {
        System.out.println("前置增强..............");
    }

    public void after1() {
        System.out.println("后置增强...............");
    }

    //环绕通知
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法之前................");
        proceedingJoinPoint.proceed();
        System.out.println("方法之后.................");
    }
}
