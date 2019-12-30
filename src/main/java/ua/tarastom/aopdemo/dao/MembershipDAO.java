package ua.tarastom.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A Membership ACCOUNT");
    }
    public void updateAccount() {
        System.out.println(getClass() + ": DOING STUFF: UPDATING A Membership ACCOUNT");
    }

    public void anyYoYo() {
        System.out.println(getClass() + ": DOING STUFF: any*() A Membership ACCOUNT");
    }
}
