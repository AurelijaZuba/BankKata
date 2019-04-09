package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class BankFeature {
    private AccountService account;
    private TransactionRepository transactionRepository;

    @Mock
    PrintManager printManager;
    @Mock
    Clock clock;

    @BeforeEach
    void setUp() {
        clock = mock(Clock.class);
        transactionRepository = new TransactionRepository(clock);
        printManager = mock(PrintManager.class);
        account = new AccountService(transactionRepository, printManager);
    }

    @Test
    void store_and_print_transactions() {
        when(clock.today()).thenReturn("01/04/2014");
        account.deposit(1000);
        when(clock.today()).thenReturn("02/04/2014");
        account.withdraw(100);
        when(clock.today()).thenReturn("10/04/2014");
        account.deposit(500);

        account.printStatement();

        verify(printManager, times(1)).printLine("DATE | AMOUNT | BALANCE");
        verify(printManager).printLine("DATE | AMOUNT | BALANCE");
        verify(printManager, times(1)).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(printManager).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(printManager, times(1)).printLine("02/04/2014 | -100.00 | 900.00");
        verify(printManager).printLine("02/04/2014 | -100.00 | 900.00");
        verify(printManager, times(1)).printLine("01/04/2014 | 1000.00 | 1000.00");
        verify(printManager).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
