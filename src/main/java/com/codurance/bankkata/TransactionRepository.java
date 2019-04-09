package com.codurance.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public List<Integer> transactions = new ArrayList<>();

    public void deposit(int amount) {
        transactions.add(amount);
    }

    public void withdraw(int amount) {
        transactions.add(-Math.abs(amount));
    }


}
