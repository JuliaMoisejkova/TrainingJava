package ru.raiffeisen.courses;

import ru.raiffeisen.courses.atm.Atm;
import ru.raiffeisen.courses.atm.accounts.Credit;
import ru.raiffeisen.courses.atm.accounts.Current;
import ru.raiffeisen.courses.atm.accounts.Debit;
import ru.raiffeisen.courses.atm.logic.BusinessLogic;
import ru.raiffeisen.courses.atm.user.UserAccounts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Atm atm = new Atm();
        UserAccounts userAccounts = new UserAccounts(new Current(1000), new Debit(1500), new Credit(-2500));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип счета для работы  цифрой 1- текущий, 2- дебетовый, 3- кредитный :");

        String i = scanner.next();

        do {
            switch (i) {
                case "1":

                    i = BusinessLogic.accountOperation(userAccounts.getCurrent(), scanner, atm, userAccounts);
                    break;

                case "2":
                    if (userAccounts.getCredit().getBalance() > -20000) {
                        i = BusinessLogic.accountOperation(userAccounts.getDebit(), scanner, atm, userAccounts);
                    } else {
                        System.out.println("Баланс кредитного счета менее -20000, работа с Дб счетом запрещена");
                        i = "111";
                    }
                    break;

                case "3":
                    i = BusinessLogic.accountOperation(userAccounts.getCredit(), scanner, atm, userAccounts);
                    break;

                default:
                    System.out.println("Неверный ввод! Выберите тип счета для работы  цифрой 1- текущий, 2- дебетовый, 3- кредитный : ");
                    i = scanner.next();
            }
        } while (i != "111");
    }
}
