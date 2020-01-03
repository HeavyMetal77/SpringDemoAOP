package ua.tarastom.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class MyFortuneLogAdvice {
    private Logger myLogger = Logger.getLogger(getClass().getName());


    @Around("execution(* ua.tarastom.aopdemo.service.*.get*())")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {
        // print out method we are advising on
        String method = pjp.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = pjp.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }
}
