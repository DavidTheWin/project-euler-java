package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemThreeTest {
    @Test
    void canFindLargestPrimeOfTwentyFive() {
        var result = ProblemThree.largestPrimeFactorOf(25);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void canFindLargestPrimeOfGivenNumber() {
        var result = ProblemThree.largestPrimeFactorOf(13195);

        assertThat(result).isEqualTo(29);
    }

    @Test
    void canFindLargestPrimeOfTestNumber() {
        var result = ProblemThree.largestPrimeFactorOf(600851475143L);

        assertThat(result).isEqualTo(6857);
    }
}