package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemSixTest {
    @Test
    void canCalculateTheSumSquareDifferenceUpToTen() {
        assertThat(ProblemSix.sumSquareDifferenceUpTo(10))
                .isEqualTo(2640);
    }

    @Test
    void canCalculateTheSumSquareDifferenceUpToOneHundred() {
        assertThat(ProblemSix.sumSquareDifferenceUpTo(100))
                .isEqualTo(25164150);
    }
}
