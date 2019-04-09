package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

public class BankFeature {
    private AccountService account;
    private PrintManager printService;

    @BeforeEach
    void setUp() {
        account = new AccountService();
        printService = new PrintManager();
    }

    @Test
    void store_and_print_transactions() {
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(printService).printLine("date || amount || balance");
        verify(printService).printLine("10/04/2014| 500.00  | 1400.00");
        verify(printService).printLine("02/04/2014| -100.00 | 900.00");
        verify(printService).printLine("01/04/2014| 1000.00 | 1000.00");
    }
}
