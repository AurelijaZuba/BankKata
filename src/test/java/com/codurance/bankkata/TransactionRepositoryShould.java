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

        Transaction transaction = transactionRepository.transactions.get(0);
        assertThat(transaction.amount).isEqualTo(1000);    }

    @Test
    void store_a_withdrawal_of_100() {
        transactionRepository.withdraw(100);

        Transaction transaction = transactionRepository.transactions.get(0);
        assertThat(transaction.amount).isEqualTo(-100);
    }

    @Test
    void generate_transaction_date() {
        transactionRepository.deposit(1000);

        Transaction transaction = transactionRepository.transactions.get(0);
        assertThat(transaction.date).isEqualTo("10/04/2014");
    }

}
