package com.thinking.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 *
 * @author vlin 2022/5/29
 */
@Aspect
@Component
@Order(2)
public class MyAspect2 {

  //定义切点
  @Pointcut("execution(* com.thinking.aop.UserServiceImpl.printUser(..))")
  public void pointCut() {
  }

  @Before("pointCut()")
  public void before() {
    System.out.println("-----Before2-----");
  }

  @After("pointCut()")
  public void after() {
    System.out.println("-----After2-----");
  }

  @AfterReturning("pointCut()")
  public void afterReturning() {
    System.out.println("-----AfterReturning2-----");
  }

  @AfterThrowing("pointCut()")
  public void afterThrowing() {
    System.out.println("-----AfterThrowing2-----");
  }

  @Around("pointCut()")
  public void around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("around advise2 1");
    //回调目标对象的原有方法
    pjp.proceed();
    System.out.println("around advise2 2");
  }
}
