package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProblemFiveTest {
    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToThree() {
        assertThat(ProblemFive.smallestNumberEvenlyDivisibleByNumbersUpTo(3))
                .isEqualTo(6);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToTen() {
        assertThat(ProblemFive.smallestNumberEvenlyDivisibleByNumbersUpTo(10))
                .isEqualTo(2520);
    }

    @Test
    void canFindSmallestNumberEvenlyDivisibleByNumbersUpToTwenty() {
        assertThat(ProblemFive.smallestNumberEvenlyDivisibleByNumbersUpTo(20))
                .isEqualTo(232792560);
    }

    @Test
    void throwsIllegalArgumentExceptionWhenGivenALowLimit() {
        assertThatThrownBy(() -> ProblemFive.smallestNumberEvenlyDivisibleByNumbersUpTo(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The limit must be at least 1, was 0");
    }
}
