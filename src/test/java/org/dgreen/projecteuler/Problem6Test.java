package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem6Test {
    @Test
    void canCalculateTheSumSquareDifferenceUpToTen() {
        assertThat(Problem6.sumSquareDifferenceUpTo(10))
                .isEqualTo(2640);
    }

    @Test
    void canCalculateTheSumSquareDifferenceUpToOneHundred() {
        assertThat(Problem6.sumSquareDifferenceUpTo(100))
                .isEqualTo(25164150);
    }
}
