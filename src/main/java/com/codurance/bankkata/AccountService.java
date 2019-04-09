package com.codurance.bankkata;

public class AccountService {

    private TransactionRepository transactionRepository;

    public AccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        throw new UnsupportedOperationException();

    }

    public void printStatement() {
        throw new UnsupportedOperationException();

    }
}
