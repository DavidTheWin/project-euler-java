package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem14Test {
    @Test
    void canFindTheNumberWithTheLongestChainUnderTen() {
        assertThat(Problem14.numberThatHasTheLongestChainUpToN(10))
                .isEqualTo(9);
    }

    @Test
    void canFindTheNumberWithTheLongestChainUnderOneMillion() {
        assertThat(Problem14.numberThatHasTheLongestChainUpToN(1000000))
                .isEqualTo(837799);
    }
}
