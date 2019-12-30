package ua.tarastom.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>>>>> Executing @Before advice add....");
    }

    @Before("execution(public void ua.tarastom.aopdemo.dao.MembershipDAO.updateAccount())")
    public void beforeUpdateAccountAdvice() {
        System.out.println("=====>>>>> Executing @Before advice update....");
    }

    @Before("execution(public void any*())")
    public void beforeAnySmthToDoAdvice() {
        System.out.println("=====>>>>> Executing @Before AnySmthToDo advice....");
    }

    @Before("execution(* any*())")
    public void beforeAnyAnyAdvice() {
        System.out.println("=====>>>>> Executing @Before AnyAny advice....");
    }

}
