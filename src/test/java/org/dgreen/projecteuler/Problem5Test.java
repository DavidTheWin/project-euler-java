package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem5Test {
    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToOne() {
        assertThat(Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(1))
                .isEqualTo(1);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToTwo() {
        assertThat(Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(2))
                .isEqualTo(2);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToThree() {
        assertThat(Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(3))
                .isEqualTo(6);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToTen() {
        assertThat(Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(10))
                .isEqualTo(2520);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToTwenty() {
        assertThat(Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(20))
                .isEqualTo(232792560);
    }

    @Test
    void throwsIllegalArgumentExceptionWhenGivenALowLimit() {
        assertThatThrownBy(() -> Problem5.smallestNumberEvenlyDivisibleByNumbersUpTo(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The limit must be at least 1, was 0");
    }
}
