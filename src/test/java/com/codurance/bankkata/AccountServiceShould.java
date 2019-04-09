package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountServiceShould {

    private AccountService account;

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    PrintManager printManager;

    @BeforeEach
    void setUp() {
        printManager = mock(PrintManager.class);
        transactionRepository = mock(TransactionRepository.class);
        account = new AccountService(transactionRepository, printManager);
    }

    @Test
    void make_a_deposit_of_1000() {
        account.deposit(1000);

        verify(transactionRepository).deposit(1000);
    }

    @Test
    void make_a_withdrawal_of_100() {
        account.withdraw(100);

        verify(transactionRepository).withdraw(100);
    }

    @Test
    void print_transaction_header() {
        account.printStatement();

        verify(printManager).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    void print_header_and_the_first_transaction() {
        account.deposit(1000);
        List<Transaction> transactionsInReverseResponse = new ArrayList<>();
        transactionsInReverseResponse.add(new Transaction("01/04/2014", 1000,1000));
        when(transactionRepository.getTransactionsInReverse()).thenReturn(transactionsInReverseResponse);

        account.printStatement();

        verify(printManager, times(1)).printLine("DATE | AMOUNT | BALANCE");
        verify(printManager, times(1)).printLine("01/04/2014 | 1000.00 | 1000.00");
    }

    @Test
    void print_multiple_transactions_in_reverse() {
        account.deposit(1000);
        account.withdraw(100);
        List<Transaction> transactionsInReverseResponse = new ArrayList<>();
        transactionsInReverseResponse.add(new Transaction("01/04/2014", 1000,1000));
        transactionsInReverseResponse.add(new Transaction("02/04/2014", -100,900));
        when(transactionRepository.getTransactionsInReverse()).thenReturn(transactionsInReverseResponse);

        account.printStatement();

        verify(printManager, times(1)).printLine("DATE | AMOUNT | BALANCE");
        verify(printManager, times(1)).printLine("01/04/2014 | 1000.00 | 1000.00");
        verify(printManager, times(1)).printLine("02/04/2014 | -100.00 | 900.00");

    }
}
