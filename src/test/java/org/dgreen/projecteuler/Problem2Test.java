package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void canCalculateEvenFibonacciSumUpToFourMillion() {
        var result = Problem2.calculateEvenFibonacciSumUpTo(4000000);

        assertThat(result).isEqualTo(4613732);
    }
}
