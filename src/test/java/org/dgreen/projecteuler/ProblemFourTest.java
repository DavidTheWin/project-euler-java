package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemFourTest {
    @Test
    void canFindLargestPalindromeByProductsOfTwoDigitNumbers() {
        assertThat(ProblemFour.largestPalindromeByProductsUpTo(99)).isEqualTo(9009);
    }

    @Test
    void canFindLargestPalindromeByProductsOfThreeDigitNumbers() {
        assertThat(ProblemFour.largestPalindromeByProductsUpTo(999)).isEqualTo(906609);
    }
}
