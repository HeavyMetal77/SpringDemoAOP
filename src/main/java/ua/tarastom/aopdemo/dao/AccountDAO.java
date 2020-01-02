package ua.tarastom.aopdemo.dao;

import org.springframework.stereotype.Component;
import ua.tarastom.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccounts() {
        ArrayList<Account> myAccounts = new ArrayList<Account>();
        Account account1 = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platinum");
        Account account3 = new Account("Luka", "Gold");
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);
        return myAccounts;
    }
}
