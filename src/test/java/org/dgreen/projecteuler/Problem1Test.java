package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void canCalculateSumUpToTen() {
        var result = Problem1.calculateSumOfThreesAndFivesUpTo(10);

        assertThat(result).isEqualTo(23);
    }

    @Test
    void canCalculateSumUpToOneThousand() {
        var result = Problem1.calculateSumOfThreesAndFivesUpTo(1000);

        assertThat(result).isEqualTo(233168);
    }
}
