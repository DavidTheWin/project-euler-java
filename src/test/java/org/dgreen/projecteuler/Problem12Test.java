package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem12Test {
    @Test
    void canFindTheFirstTriangleNumberWithOverFiveDivisors() {
        assertThat(Problem12.firstTriangleNumberWithAtLeastNDivisors(5))
                .isEqualTo(28);
    }

    @Test
    void canFindTheFirstTriangleNumberWithOverFiveHundredDivisors() {
        assertThat(Problem12.firstTriangleNumberWithAtLeastNDivisors(500))
                .isEqualTo(76576500);
    }
}
