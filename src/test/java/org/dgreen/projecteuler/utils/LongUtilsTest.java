package org.dgreen.projecteuler.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LongUtilsTest {
    @ParameterizedTest
    @ValueSource(longs = {-8, -6, -4, -2, 0, 2, 4, 6, 8, Long.MIN_VALUE})
    void isEvenReturnsTrueWhenGivenAnEvenNumber(long number) {
        assertThat(LongUtils.isEven(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {-7, -5, -3, -1, 1, 3, 5, 7, Long.MAX_VALUE})
    void isEvenReturnsFalseWhenGivenAnOddNumber(long number) {
        assertThat(LongUtils.isEven(number)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("numbersDivisibleByTheOther")
    void isDivisibleByReturnsTrueWhenDivisible(long number, long divisor) {
        assertThat(LongUtils.isDivisibleBy(number, divisor)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("numbersNotDivisibleByTheOther")
    void isDivisibleByReturnsFalseWhenNotDivisible(long number, long divisor) {
        assertThat(LongUtils.isDivisibleBy(number, divisor)).isFalse();
    }

    @Test
    void isDivisibleByThrowsWhenDividingByZero() {
        assertThatThrownBy(() -> LongUtils.isDivisibleBy(2, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @ParameterizedTest
    @MethodSource("numbersWithUpperPrimeFactorLimit")
    void canFindTheUpperPrimeFactorLimitOfANumber(long number, long upperLimit) {
        assertThat(LongUtils.upperPrimeFactorLimitOf(number)).isEqualTo(upperLimit);
    }

    @ParameterizedTest
    @ValueSource(longs = {2, 3, 5, 7, 11, 29, 6857})
    void isPrimeReturnsTrueWhenGivenAPrimeNumber(long prime) {
        assertThat(LongUtils.isPrime(prime)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 4, 6, 9, 14})
    void isPrimeReturnsFalseWhenGivenANonPrimeNumber(long notPrime) {
        assertThat(LongUtils.isPrime(notPrime)).isFalse();
    }

    private static Stream<Arguments> numbersDivisibleByTheOther() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(4, 2),
                Arguments.of(9, 3)
        );
    }

    private static Stream<Arguments> numbersNotDivisibleByTheOther() {
        return Stream.of(
                Arguments.of(3, 2),
                Arguments.of(5, 2),
                Arguments.of(9, 4)
        );
    }

    private static Stream<Arguments> numbersWithUpperPrimeFactorLimit() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(9, 3),
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(11, 4),
                Arguments.of(20, 5)
        );
    }
}
