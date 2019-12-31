package ua.tarastom.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tarastom.aopdemo.dao.AccountDAO;
import ua.tarastom.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = applicationContext.getBean("accountDAO", AccountDAO.class);

        accountDao.addAccount();

        System.out.println("\n Let`s call it again....\n");

        accountDao.addAccount();

        System.out.println("\n Let`s call membership....\n");
        MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();

        System.out.println("\n Let`s call update membership....\n");
        membershipDAO.updateAccount();

        System.out.println("\n Let`s call anyYoYo membership....\n");
        membershipDAO.anyYoYo();

        System.out.println("\n Let`s call addAccountWithParam....\n");
        Account account = new Account();
        accountDao.addAccountWithParam(account);

        System.out.println("\n Let`s call addAccountWithMultyParam....\n");
        Account account1 = new Account();
        accountDao.addAccountWithMultyParam(account1, true);

        System.out.println("\n Let`s call addAccountWithMultyParam....\n");
        accountDao.plusPointcut(account, false);



        applicationContext.close();
    }
}
