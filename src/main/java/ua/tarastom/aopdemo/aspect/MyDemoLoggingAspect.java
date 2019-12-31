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

    @Before("execution(* add*(ua.tarastom.aopdemo.Account))")
    public void beforeAddAccountAdviceWithParam() {
        System.out.println("=====>>>>> Executing @Before advice addAccountWithParam....");
    }

    @Before("execution(* add*(ua.tarastom.aopdemo.Account, ..))")
    public void beforeAddAccountAdviceWithMultyParam() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceWithMultyParam....");
    }

    @Before("execution(* add*(..))") //.. - от нуля до любое ко-во параметров
    public void beforeAddAccountAdviceWithANYParam() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceWithANYParam....");
    }

    @Before("execution(* ua.tarastom.aopdemo.dao.*.*(..))") //*.* - любой клас и любой метод
    public void beforeAddAccountAdviceAnyClassAnyMethod() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceAnyClassAnyMethod....");
    }
}
