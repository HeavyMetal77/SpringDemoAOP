package ua.tarastom.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tarastom.aopdemo.dao.AccountDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDao = applicationContext.getBean("accountDAO", AccountDAO.class);

        accountDao.addAccount();

        applicationContext.close();
    }
}
