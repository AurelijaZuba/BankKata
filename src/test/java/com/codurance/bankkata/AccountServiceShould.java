package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
        account = new AccountService(transactionRepository);
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
}
