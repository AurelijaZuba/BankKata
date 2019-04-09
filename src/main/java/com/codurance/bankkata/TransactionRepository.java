package com.codurance.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        addTransaction(amount);
    }

    public void withdraw(int amount) {
        addTransaction(-Math.abs(amount));
    }

    private void addTransaction(int amount) {
        transactions.add(new Transaction("01/04/2014", amount));
    }
}
