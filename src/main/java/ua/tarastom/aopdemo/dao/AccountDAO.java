package ua.tarastom.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING IN ACCOUNT");
    }
}
