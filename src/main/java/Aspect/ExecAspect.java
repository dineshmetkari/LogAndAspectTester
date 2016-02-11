package Aspect;

import Core.MyClass;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by pm on 1/7/16.
 *
 * Aspects: * means "any"
 */

@Component
@Aspect
public class ExecAspect {
    private static Logger mylog = org.slf4j.LoggerFactory.getLogger(MyClass.class);

    //Selected method in this class
    @Before("execution(* Core.MyClass.getAplusB())")
    public void hihihi(JoinPoint joinPoint) {
        System.out.println("---BEFORE POINTCUT---");
    }

    //Any method in this package  [could specify class instead of *]
    @After("execution(* Core.M*.*())")
    public void hahaha(JoinPoint joinPoint) {
        System.out.println("+++AFTER POINTCUT+++");
    }

    @Around("execution(* Core.MyClass.longComputation())")
    public void measureDuration(ProceedingJoinPoint joinPoint) throws Throwable {
        long st = System.currentTimeMillis();
        joinPoint.proceed();
        long en = System.currentTimeMillis();
        mylog.info("Computation execution: " + (en-st) + " [ms]");

    }
}
