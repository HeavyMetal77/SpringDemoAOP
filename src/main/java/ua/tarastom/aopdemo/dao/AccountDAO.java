package ua.tarastom.aopdemo.dao;

import org.springframework.stereotype.Component;
import ua.tarastom.aopdemo.Account;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT");
    }

    public void addAccountWithParam(Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT WithParam");
    }

    public void addAccountWithMultyParam(Account account, boolean flag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT addAccountWithMultyParam");
    }
}
