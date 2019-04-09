package com.codurance.bankkata;


import java.text.DecimalFormat;

public class Transaction {

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public final String date;
    public final int amount;
    public final int balance;

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("0.00");
        StringBuilder transactionBuilder = new StringBuilder();
        transactionBuilder.append(date);
        transactionBuilder.append(" | ");
        transactionBuilder.append(formatter.format(amount));
        transactionBuilder.append(" | ");
        transactionBuilder.append(formatter.format(balance));

        return transactionBuilder.toString();
    }
}
