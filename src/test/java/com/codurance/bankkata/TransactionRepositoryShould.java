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
        assertThat(transaction.amount).isEqualTo(1000);
    }

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
        assertThat(transaction.date).isEqualTo("01/04/2014");
    }

    @Test
    void store_current_balance() {
        transactionRepository.deposit(1000);

        Transaction transaction = transactionRepository.transactions.get(0);
        assertThat(transaction.balance).isEqualTo(1000);
    }

    @Test
    void store_multiple_specific_transaction_dates() {
        transactionRepository.deposit(1000);
        transactionRepository.withdraw(100);

        var transactions = transactionRepository.transactions;
        assertThat(transactions.size()).isEqualTo(2);
        assertThat(transactions.get(0).date).isEqualTo("01/04/2014");
        assertThat(transactions.get(1).date).isEqualTo("02/04/2014");

    }
}
