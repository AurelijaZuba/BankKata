package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankFeature {
    private AccountService account;

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    PrintManager printManager;

    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        printManager = mock(PrintManager.class);
        account = new AccountService(transactionRepository, printManager);
    }

    @Test
    void store_and_print_transactions() {
        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        verify(printManager).printLine("date || amount || balance");
        verify(printManager).printLine("10/04/2014| 500.00  | 1400.00");
        verify(printManager).printLine("02/04/2014| -100.00 | 900.00");
        verify(printManager).printLine("01/04/2014| 1000.00 | 1000.00");
    }
}
