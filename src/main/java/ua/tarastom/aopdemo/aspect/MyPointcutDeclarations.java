package ua.tarastom.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ua.tarastom.aopdemo.Account;

@Aspect
@Component
public class MyPointcutDeclarations {

    @Pointcut("execution(* plusPoint*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void plusNewPoitcut() {
        System.out.println("=====>>>>> Executing @Before advice from Poitcut declarations....");
    }

    @Before("forDaoPackage()")
    public void nnnPoitcut() {
        System.out.println("=====>>>>> Executing @Before advice from nnnPoitcut....");
    }
}
