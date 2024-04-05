package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void canFindLargestPrimeOfTwentyFive() {
        var result = Problem3.largestPrimeFactorOf(25);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void canFindLargestPrimeOfGivenNumber() {
        var result = Problem3.largestPrimeFactorOf(13195);

        assertThat(result).isEqualTo(29);
    }

    @Test
    void canFindLargestPrimeOfTestNumber() {
        var result = Problem3.largestPrimeFactorOf(600851475143L);

        assertThat(result).isEqualTo(6857);
    }
}
