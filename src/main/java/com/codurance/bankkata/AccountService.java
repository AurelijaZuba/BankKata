package com.codurance.bankkata;


public class AccountService {

    private TransactionRepository transactionRepository;
    private PrintManager printManager;

    public AccountService(TransactionRepository transactionRepository, PrintManager printManager) {
        this.transactionRepository = transactionRepository;
        this.printManager = printManager;
    }

    public void deposit(int amount) {
        transactionRepository.deposit(amount);

    }

    public void withdraw(int amount) {
        transactionRepository.withdraw(amount);

    }

    public void printStatement() {
        printManager.printLine("DATE | AMOUNT | BALANCE");

        transactionRepository.getTransactionsInReverse().forEach((item) -> {
            printManager.printLine(item.toString());
        });
    }
}
