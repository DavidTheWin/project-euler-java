package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {
    @Test
    void canFindTheSixthPrimeNumber() {
        assertThat(Problem7.nthPrimeNumber(6))
                .isEqualTo(13);
    }

    @Test
    void canFindTheTenThousandAndFirstPrimeNumber() {
        assertThat(Problem7.nthPrimeNumber(10001))
                .isEqualTo(104743);
    }
}
