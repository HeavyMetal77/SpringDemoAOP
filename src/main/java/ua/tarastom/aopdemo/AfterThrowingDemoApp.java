package ua.tarastom.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tarastom.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = applicationContext.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;

        try {
            boolean flag = true;
            accounts = accountDao.findAccounts(flag);
        } catch (Exception theException) {
            System.out.println("\n\nMain program caught exception...: " + theException);
        }
        System.out.println("Main program: AfterThrowingDemoApp ");
        System.out.println(accounts);

        applicationContext.close();
    }
}
