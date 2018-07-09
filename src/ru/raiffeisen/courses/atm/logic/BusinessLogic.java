package ru.raiffeisen.courses.atm.logic;

import ru.raiffeisen.courses.atm.Atm;
import ru.raiffeisen.courses.atm.accounts.Account;
import ru.raiffeisen.courses.atm.accounts.Current;
import ru.raiffeisen.courses.atm.accounts.Debit;
import ru.raiffeisen.courses.atm.user.UserAccounts;

import java.util.Scanner;

public class BusinessLogic {

    private final static String bonus = "2000";

    public static String accountOperation(Account acc, Scanner scanner, Atm atm, UserAccounts userAccounts) {
        System.out.println("Выберите тип операции цифрой: 1- внесение, 2- снятие ; 3-перевод между счетами :");
        String a = scanner.next();
        String _sumCasch;
        int i;
        switch (a) {
            case "1":
                _sumCasch = sumCash(scanner);
                i = Integer.valueOf(_sumCasch);
                if (acc instanceof Current && i > 1000000) {
                    atm.incrementBalance(userAccounts.getDebit(), bonus);
                    atm.incrementBalance(acc, _sumCasch);
                } else {
                    atm.incrementBalance(acc, _sumCasch);
                }
                System.out.println(acc.getBalance());
                System.out.println("внести");
                System.out.println(acc.getClass().getName());

                return "111";
            case "2":
                _sumCasch = sumCash(scanner);
                i = Integer.valueOf(_sumCasch);
                atm.decrementBalance(acc, _sumCasch);
                System.out.println(acc.getBalance());
                System.out.println("снять");
                System.out.println(acc.getClass().getName());
                break;

            case "3":
                _sumCasch = sumCash(scanner);
                atm.transferBalance(acc, acctTransfer(accountChoice(acc, scanner), userAccounts), _sumCasch);
                System.out.println("Баланс текущего счета  =  " + userAccounts.getCurrent().getBalance());
                System.out.println("Баланс дебетового счета  =  " + userAccounts.getDebit().getBalance());
                System.out.println("Баланс кредитного счета  =  " + userAccounts.getCredit().getBalance());
                System.out.println("перевести");
                break;
            default:
                System.out.println("Неверный ввод");
                System.out.println("Выберите тип операции цифрой: 1- внесение, 2- снятие ; 3-перевод между счетами :");
                a = scanner.next();
                break;
        }
        return "111";
    }

    private static String sumCash(Scanner scanner) {
        System.out.println("Введите сумму цифрами");
        return scanner.next();
    }

    private static String accountChoice(Account account, Scanner scanner) {

        if (account instanceof Current) {
            System.out.println("Выберите тип счета, на который будет осуществлен перевод: 2- дебетовый, 3-кредитный");
            return checkAccountTransfer(scanner.next(), scanner);
        } else if (account instanceof Debit) {
            System.out.println("Выберите тип счета, на который будет осуществлен перевод: 1- текущий, 3-кредитный");
            checkAccountTransfer(scanner.next(), scanner);
            return scanner.next();
        } else {
            System.out.println("Выберите тип счета, на который будет осуществлен перевод: 1- текущий, 2-дебетовый");
            checkAccountTransfer(scanner.next(), scanner);
            return scanner.next();
        }
    }


    private static Account acctTransfer(String instance, UserAccounts userAccounts) {
        switch (instance) {
            case "1":
                return userAccounts.getCurrent();
            case "2":
                return userAccounts.getDebit();
            case "3":
                return userAccounts.getCredit();
            default:
                return null;
        }
    }

    private static String checkAccountTransfer(String accountType, Scanner scanner) {

        while (!accountType.equals("1") && !accountType.equals("2") && !accountType.equals("3")) {
            System.out.println("Неверный ввод типа счета.Введите тип счета еще раз");
            accountType = scanner.next();
        }
        return accountType;
    }
}
