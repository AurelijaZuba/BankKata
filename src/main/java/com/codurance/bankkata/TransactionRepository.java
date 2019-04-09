package com.codurance.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Transaction> transactions = new ArrayList<>();
    private Clock clock;

    public TransactionRepository(Clock clock) {

        this.clock = clock;
    }

    public void deposit(int amount) {
        addTransaction(amount);
    }

    public void withdraw(int amount) {
        addTransaction(-Math.abs(amount));
    }

    private void addTransaction(int amount) {
        var balance = transactions.stream()
                .mapToInt((transaction) -> transaction.amount)
                .sum() + amount;

        transactions.add(new Transaction(clock.today(), amount, balance));
    }

    public Iterable<Transaction> getTransactionsInReverse() {
        return null;
    }
}
