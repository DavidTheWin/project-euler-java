package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem8Test {
    @Test
    void canFindTheLargestProductOfAdjacentFourDigitNumbers() {
        assertThat(Problem8.greatestProductOfAdjacentNDigits(4))
                .isEqualTo(5832);
    }

    @Test
    void canFindTheLargestProductOfAdjacentThirteenDigitNumbers() {
        assertThat(Problem8.greatestProductOfAdjacentNDigits(13))
                .isEqualTo(23514624000L);
    }
}
