package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class AccountServiceShould {

    @Mock
    TransactionRepository transactionRepository;

    private AccountService account;

    @BeforeEach
    void setUp() {
        account = new AccountService();
    }

    @Test
    void make_A_deposit_of_1000() {
        account.deposit(1000);

        verify(transactionRepository).addDeposit(1000);
    }
}
