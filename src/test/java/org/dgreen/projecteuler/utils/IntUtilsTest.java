package org.dgreen.projecteuler.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {-8, -6, -4, -2, 0, 2, 4, 6, 8, Integer.MIN_VALUE})
    void isEvenReturnsTrueWhenGivenAnEvenNumber(int number) {
        assertThat(IntUtils.isEven(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, -5, -3, -1, 1, 3, 5, 7, Integer.MAX_VALUE})
    void isEvenReturnsFalseWhenGivenAnOddNumber(int number) {
        assertThat(IntUtils.isEven(number)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("numbersDivisibleByTheOther")
    void isDivisibleByReturnsTrueWhenDivisible(int number, int divisor) {
        assertThat(IntUtils.isDivisibleBy(number, divisor)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("numbersNotDivisibleByTheOther")
    void isDivisibleByReturnsFalseWhenNotDivisible(int number, int divisor) {
        assertThat(IntUtils.isDivisibleBy(number, divisor)).isFalse();
    }

    @Test
    void isDivisibleByThrowsWhenDividingByZero() {
        assertThatThrownBy(() -> IntUtils.isDivisibleBy(2, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @ParameterizedTest
    @MethodSource("numbersDivisibleByAllDivisors")
    void isDivisibleByNumbersReturnsTrueWhenDivisibleByAllDivisors(int number, int[] divisors) {
        assertThat(IntUtils.isDivisibleByNumbers(number, divisors)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 121, 1331, 9009})
    void isPalindromeReturnsTrueWhenGivenAPalindrome(int palindrome) {
        assertThat(IntUtils.isPalindrome(palindrome)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 12, 123, 1335, 9109})
    void isPalindromeReturnsFalseWhenGivenANonPalindrome(int notPalindrome) {
        assertThat(IntUtils.isPalindrome(notPalindrome)).isFalse();
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

    private static Stream<Arguments> numbersDivisibleByAllDivisors() {
        return Stream.of(
                Arguments.of(1, new int[] { 1 }),
                Arguments.of(6, new int[] { 1, 2, 3, 6 }),
                Arguments.of(2520, IntStream.rangeClosed(1, 10).toArray())
        );
    }
}