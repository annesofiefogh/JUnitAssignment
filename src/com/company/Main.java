package com.company;

public class Main {

    public static void main(String[] args) {

        Account account1 = new Account("1452", "Frank Steen", 50);
        Account account2 = new Account("4678", "Karen Jeppesen");

        String insertAmount = account1.insert(101);
        System.out.println(insertAmount);

        String withDrawAmount = account1.withdraw(56);
        System.out.println(withDrawAmount);

        System.out.println(account1);
        System.out.println(account2);

        String transferMoney = account1.transfer(40, account2);
        System.out.println(transferMoney);
    }
}
