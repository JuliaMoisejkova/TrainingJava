package ru.raiffeisen.courses.atm;

import ru.raiffeisen.courses.atm.accounts.Account;

public interface IManageAccounts {

   Integer checkBalance(Account account);

   void incrementBalance(Account account, String cash);

   void decrementBalance (Account account, String cash);

   void transferBalance (Account db, Account cr, String cash);
}
