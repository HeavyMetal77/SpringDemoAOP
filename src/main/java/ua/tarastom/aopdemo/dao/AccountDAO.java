package ua.tarastom.aopdemo.dao;

import org.springframework.stereotype.Component;
import ua.tarastom.aopdemo.Account;

@Component
public class AccountDAO {
    private String name;
    private String serviceCod;

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT");
    }

    public void addAccountWithParam(Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT WithParam");
    }

    public void addAccountWithMultyParam(Account account, boolean flag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT addAccountWithMultyParam");
    }

    public void plusPointcut(Account account, boolean flag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT plusPointcut");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCod() {
        System.out.println(getClass() + ": in getServiceCod()");
        return serviceCod;
    }

    public void setServiceCod(String serviceCod) {
        System.out.println(getClass() + ": in setServiceCod()");
        this.serviceCod = serviceCod;
    }
}
