package ua.tarastom.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ua.tarastom.aopdemo.Account;

import java.util.List;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>>>>> Executing @Before advice add....");
        System.out.println("========== order 2");
    }

    @Before("execution(public void ua.tarastom.aopdemo.dao.MembershipDAO.updateAccount())")
    public void beforeUpdateAccountAdvice() {
        System.out.println("=====>>>>> Executing @Before advice update....");
        System.out.println("========== order 2");
    }

    @Before("execution(public void any*())")
    public void beforeAnySmthToDoAdvice() {
        System.out.println("=====>>>>> Executing @Before AnySmthToDo advice....");
        System.out.println("========== order 2");
    }

    @Before("execution(* any*())")
    public void beforeAnyAnyAdvice() {
        System.out.println("========== order 2");
        System.out.println("=====>>>>> Executing @Before AnyAny advice....");
    }

    @Before("execution(* add*(ua.tarastom.aopdemo.Account))")
    public void beforeAddAccountAdviceWithParam() {
        System.out.println("=====>>>>> Executing @Before advice addAccountWithParam....");
        System.out.println("========== order 2");
    }

    @Before("execution(* add*(ua.tarastom.aopdemo.Account, ..))")
    public void beforeAddAccountAdviceWithMultyParam() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceWithMultyParam....");
        System.out.println("========== order 2");
    }

    @Before("execution(* add*(..))") //.. - от нуля до любое ко-во параметров
    public void beforeAddAccountAdviceWithANYParam() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceWithANYParam....");
        System.out.println("========== order 2");
    }

    @Before("execution(* ua.tarastom.aopdemo.dao.*.*(..))") //*.* - любой клас и любой метод
    public void beforeAddAccountAdviceAnyClassAnyMethod() {
        System.out.println("=====>>>>> Executing @Before advice AddAccountAdviceAnyClassAnyMethod....");
        System.out.println("========== order 2");
    }

    @Before("execution(* ua.tarastom.aopdemo.dao.*.*(..))") //*.* - любой клас и любой метод
    public void beforeAddAccountJoinPoint(JoinPoint joinPoint) {//AOP Read Method Arguments with JoinPoints
        System.out.println("=====>>>>> Executing @Before advice beforeAddAccountJoinPoint....");
        System.out.println("========== order 2");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature(); //получаем сигнатуру метода
        System.out.println("Signature of method: " + signature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("Parameters of method: " + arg);
        }
    }

    //@AfterReturning advice for findAccount method
    @AfterReturning(pointcut = "execution(* ua.tarastom.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result1")
    public void afterReturningForFindAccountsAdvice(JoinPoint joinPoint, List<Account> result1) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result1);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        // loop through accounts
        for (Account tempAccount : result1) {
            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);
        }
        System.out.println("\n=====>>> result after converting is: " + result1);
    }

    @AfterThrowing(pointcut = "execution(* ua.tarastom.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingForFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    @After("execution(* ua.tarastom.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }
}


