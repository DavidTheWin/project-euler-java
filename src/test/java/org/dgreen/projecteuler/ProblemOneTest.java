package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemOneTest {
    @Test
    void canCalculateSumUpToTen() {
        var result = ProblemOne.calculateSumOfThreesAndFivesUpTo(10);

        assertThat(result).isEqualTo(23);
    }

    @Test
    void canCalculateSumUpToOneThousand() {
        var result = ProblemOne.calculateSumOfThreesAndFivesUpTo(1000);

        assertThat(result).isEqualTo(233168);
    }
}