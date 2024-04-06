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

    @ParameterizedTest
    @MethodSource("numbersWithUpperPrimeFactorLimit")
    void canFindTheUpperPrimeFactorLimitOfANumber(int number, int upperLimit) {
        assertThat(IntUtils.upperPrimeFactorLimitOf(number)).isEqualTo(upperLimit);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 29, 6857})
    void isPrimeReturnsTrueWhenGivenAPrimeNumber(int prime) {
        assertThat(IntUtils.isPrime(prime)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 9, 14})
    void isPrimeReturnsFalseWhenGivenANonPrimeNumber(int notPrime) {
        assertThat(IntUtils.isPrime(notPrime)).isFalse();
    }

    @Test
    void canFindNumberOfDivisorsOfANumber2() {
        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            var naiveCount = IntStream.rangeClosed(1, i)
                    .filter(it -> IntUtils.isDivisibleBy(finalI, it))
                    .count();

            assertThat(IntUtils.numberOfDivisorsOf(i)).isEqualTo(naiveCount);
        }
    }

    @ParameterizedTest
    @MethodSource("nthTriangleNumber")
    void canCalculateTriangleNumbers(int n, int triangleNumber) {
        assertThat(IntUtils.nthTriangleNumber(n)).isEqualTo(triangleNumber);
    }

    @ParameterizedTest
    @MethodSource("squaresOrNot")
    void canDetermineWhetherANumberIsSquare(int number, boolean isSquare) {
        assertThat(IntUtils.isSquare(number)).isEqualTo(isSquare);
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

    private static Stream<Arguments> nthTriangleNumber() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(2, 3),
                Arguments.of(7, 28)
        );
    }

    private static Stream<Arguments> squaresOrNot() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(4, true),
                Arguments.of(5, false),
                Arguments.of(16, true),
                Arguments.of(25, true),
                Arguments.of(50, false)
        );
    }
}
