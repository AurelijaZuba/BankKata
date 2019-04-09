package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

public class TransactionRepositoryShould {

    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepository();

    }

    @Test
    void store_a_deposit_of_1000() {
        transactionRepository.deposit(1000);

        verify(transactionRepository.amount);
    }
}
