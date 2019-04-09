package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionRepositoryShould {

    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        transactionRepository = new TransactionRepository();

    }

    @Test
    void store_a_deposit_of_1000() {
        transactionRepository.deposit(1000);

        assertThat(transactionRepository.transactions.get(0)).isEqualTo(1000);
    }

    @Test
    void store_a_withdrawal_of_100() {
        transactionRepository.withdraw(100);

        assertThat(transactionRepository.transactions.get(0)).isEqualTo(-100);
    }

}
