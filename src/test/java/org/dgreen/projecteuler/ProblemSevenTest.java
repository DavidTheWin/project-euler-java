package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemSevenTest {
    @Test
    void canFindTheSixthPrimeNumber() {
        assertThat(ProblemSeven.nthPrimeNumber(6))
                .isEqualTo(13);
    }

    @Test
    void canFindTheTenThousandAndFirstPrimeNumber() {
        assertThat(ProblemSeven.nthPrimeNumber(10001))
                .isEqualTo(104743);
    }
}
