package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemTwoTest {
    @Test
    void canCalculateEvenFibonacciSumUpToFourMillion() {
        var result = ProblemTwo.calculateEvenFibonacciSumUpTo(4000000);

        assertThat(result).isEqualTo(4613732);
    }
}