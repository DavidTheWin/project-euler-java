package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem21Test {
    @Test
    void canSumAmicableNumbersUnderTenThousand() {
        assertThat(Problem21.sumOfAmicableNumbersUpTo(10000)).isEqualTo(31626);
    }
}
