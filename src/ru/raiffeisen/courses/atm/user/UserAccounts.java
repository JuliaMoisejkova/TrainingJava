package ru.raiffeisen.courses.atm.user;

import ru.raiffeisen.courses.atm.accounts.Account;
import ru.raiffeisen.courses.atm.accounts.Credit;
import ru.raiffeisen.courses.atm.accounts.Current;
import ru.raiffeisen.courses.atm.accounts.Debit;

public class UserAccounts {
    private Current current;
    private Debit debit;
    private Credit credit;

    public UserAccounts(Current current, Debit debit, Credit credit) {
        this.current = current;
        this.debit = debit;
        this.credit = credit;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "UserAccounts{" +
                "current=" + current +
                ", debit=" + debit +
                ", credit=" + credit +
                '}';
    }
}
