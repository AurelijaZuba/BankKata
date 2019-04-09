package com.codurance.bankkata;

import java.util.Objects;

public class Transaction {
    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public final String date;
    public final int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
