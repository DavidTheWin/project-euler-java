package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemTenTest {
    @Test
    void canCalculateTheSumOfPrimesBelowTen() {
        assertThat(ProblemTen.sumOfPrimesUpTo(10))
                .isEqualTo(17);
    }

    @Test
    void canCalculateTheSumOfPrimesBelowTwoMillion() {
        assertThat(ProblemTen.sumOfPrimesUpTo(2000000))
                .isEqualTo(142913828922L);
    }
}
