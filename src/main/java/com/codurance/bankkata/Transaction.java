package com.codurance.bankkata;

public class Transaction {

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public final String date;
    public final int amount;
    public final int balance;

}
