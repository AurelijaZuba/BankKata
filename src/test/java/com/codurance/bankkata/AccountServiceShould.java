package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class AccountServiceShould {

    private AccountService account;

    @Mock
    TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        account = new AccountService(transactionRepository);
    }

    @Test
    void make_A_deposit_of_1000() {
        account.deposit(1000);

        verify(transactionRepository).addDeposit(1000);
    }
}
