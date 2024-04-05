package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem10Test {
    @Test
    void canCalculateTheSumOfPrimesBelowTen() {
        assertThat(Problem10.sumOfPrimesUpTo(10))
                .isEqualTo(17);
    }

    @Test
    void canCalculateTheSumOfPrimesBelowTwoMillion() {
        assertThat(Problem10.sumOfPrimesUpTo(2000000))
                .isEqualTo(142913828922L);
    }
}
