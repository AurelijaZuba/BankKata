package com.codurance.bankkata;

public class AccountService {

    private TransactionRepository transactionRepository;

    public AccountService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.deposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.withdraw(amount);

    }

    public void printStatement() {
        throw new UnsupportedOperationException();

    }
}
