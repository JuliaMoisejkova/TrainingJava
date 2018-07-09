package ru.raiffeisen.courses.atm;

import ru.raiffeisen.courses.atm.accounts.Account;

public class Atm implements IManageAccounts {

    @Override
    public Integer checkBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public void incrementBalance(Account account, String cash) {
        account.setBalance(account.getBalance() + Integer.valueOf(cash));
    }

    @Override
    public void decrementBalance(Account account, String cash) {
        account.setBalance(account.getBalance() - Integer.valueOf(cash));
    }

    @Override
    public void transferBalance(Account db, Account cr, String cash) {
        db.setBalance(db.getBalance() - Integer.valueOf(cash));
        cr.setBalance(cr.getBalance() + Integer.valueOf(cash));
    }
}
