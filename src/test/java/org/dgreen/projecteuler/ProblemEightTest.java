package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemEightTest {
    @Test
    void canFindTheLargestProductOfAdjacentFourDigitNumbers() {
        assertThat(ProblemEight.greatestProductOfAdjacentNDigits(4))
                .isEqualTo(5832);
    }

    @Test
    void canFindTheLargestProductOfAdjacentThirteenDigitNumbers() {
        assertThat(ProblemEight.greatestProductOfAdjacentNDigits(13))
                .isEqualTo(23514624000L);
    }
}
