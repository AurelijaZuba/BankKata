package com.codurance.bankkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockShould {

    private Clock clock;

    @BeforeEach
    void setUp() {
        clock = new Clock();
    }

    @Test
    void get_actual_date() {

        String actual = clock.today();
        assertThat(actual).isNotNull();
        assertThat(actual).isNotEmpty();
    }
}
