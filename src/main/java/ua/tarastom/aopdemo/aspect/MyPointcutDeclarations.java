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

    // create pointcut for getter methods
    @Pointcut("execution(* ua.tarastom.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* ua.tarastom.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

}
