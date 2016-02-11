package Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * Przykład wykorzystania aspektów:
 *
 * Synchronizacja wykonania metod klasy Core.Repo (wszystkich naraz)
 *
 * Wynik działania programu (trzy wątki uruchamiają metody klasy Repo):

 Aspect before lockThread[Thread-1,5,main]
 Aspect before lockThread[Thread-3,5,main]
 Aspect before lockThread[Thread-2,5,main]
 In method A : Thread[Thread-1,5,main]
 Exiting A : Thread[Thread-1,5,main]
 Aspect after lockThread[Thread-1,5,main]
 In method A : Thread[Thread-2,5,main]
 Exiting A : Thread[Thread-2,5,main]
 Aspect after lockThread[Thread-2,5,main]
 In method A : Thread[Thread-3,5,main]
 Exiting A : Thread[Thread-3,5,main]
 Aspect after lockThread[Thread-3,5,main]

 */

@Component
@Aspect
public class RepoInterceptor {
    private Object lock = new Object();


    /**
     *  Pattern in (<return_type> <classes>(<argument>))
     *
     *  return = *
     *  argument : () empty, (..) any, (*, String) = 1 arbitrary, 1 String
     */



    @Around("execution(* Core.Repo.*(..))")
    public Object lockIt(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect before lock" + Thread.currentThread());
        Object ret = null;
        synchronized (lock) {
            ret = joinPoint.proceed();
        }
        System.out.println("Aspect after lock" + Thread.currentThread());
        return ret;
    }
}

