package com.zerobase.product.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Before("execution(* com.zerobase.product.controller..*(..))")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        // 클래스 레벨에 @Controller 또는 @RestController 어노테이션이 있는 경우
        // 해당 클래스의 모든 메서드 호출 전에 실행됩니다.

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        log.info("{} API 호출 시작", method.getName());
    }

    @AfterReturning(pointcut = "execution(* com.zerobase.product.controller..*(..))", returning = "result")
    public void logAfterControllerMethod(JoinPoint joinPoint, Object result) {
        // 클래스 레벨에 @Controller 또는 @RestController 어노테이션이 있는 경우
        // 해당 클래스의 모든 메서드 호출 후에 실행됩니다.

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        log.info("{} API 호출 종료", method.getName());
    }
}
