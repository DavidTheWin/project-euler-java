package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void canFindLargestPalindromeByProductsOfTwoDigitNumbers() {
        assertThat(Problem4.largestPalindromeByProductsUpTo(99)).isEqualTo(9009);
    }

    @Test
    void canFindLargestPalindromeByProductsOfThreeDigitNumbers() {
        assertThat(Problem4.largestPalindromeByProductsUpTo(999)).isEqualTo(906609);
    }
}
