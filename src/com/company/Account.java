package com.company;

public class Account {

    private String accountNumber;
    private String ownerName;
    private double accountBalance;

    //Give en start-saldo
    public Account(String accountNumber, String ownerName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
    }

    //Ingenting som parameter
    public Account(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.accountBalance = 0;
    }

    public String insert(double insert) {
        try {
            if (insert <= 0 || insert >= 100) {
                throw new IllegalArgumentException();
            } else {
                accountBalance += insert;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Please insert an amount less than 100 kr.");
        }
        return "Your current balance is: " + accountBalance;
    }

    public String withdraw(double withdraw) {
        try {
            if (accountBalance - withdraw < 0) {
                throw new IllegalArgumentException();
            } else {
                accountBalance -= withdraw;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nYou account limit has been exceeded.");
        }
        return "Your current balance is: " + accountBalance;
    }

    //Virker ikke optimalt – udskriver korrekt men ændrer ikke i saldoerne i toString
    public String transfer(double transfer, Account destination){
        double currentTransfer = transfer + 5;
        String print = "";
        try {
            if (accountBalance - currentTransfer < 0){
                throw new IllegalArgumentException();
            } else {
                accountBalance -= currentTransfer;
                currentTransfer += destination.accountBalance;
                System.out.println("\nYou have transferred: " + currentTransfer + " kr. to " + destination.ownerName);
                print = "Your current balance: " + accountBalance;
            }
        } catch (IllegalArgumentException e){
            System.out.println("\nYour account limit has been exceeded. Transfer incomplete.");
        }
        return print;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String toString(){
        return "\nYour account: " + accountNumber + "\nOwned by: " + ownerName + "\nCurrent balance: " + accountBalance + " kr.";
    }

}
