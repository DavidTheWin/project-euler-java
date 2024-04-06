package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem11Test {
    @Test
    void canCalculateTheLargestProductInTheGrid() {
        assertThat(Problem11.largestProductInGrid())
                .isEqualTo(70600674);
    }
}
