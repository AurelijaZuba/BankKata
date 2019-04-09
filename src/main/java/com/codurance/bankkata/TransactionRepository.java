package com.codurance.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Transaction> transactions = new ArrayList<>();

    public void deposit(int amount) {
        transactions.add(new Transaction("10/04/2014", amount));
    }

    public void withdraw(int amount) {
        transactions.add(new Transaction("02/04/2014", -Math.abs(amount)));
    }

}
