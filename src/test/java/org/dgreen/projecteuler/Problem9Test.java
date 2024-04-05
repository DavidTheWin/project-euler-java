package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem9Test {
    @Test
    void canCalculateProductOfPythagoreanTripletThatSumsToOneThousand() {
        assertThat(Problem9.productOfTriplet())
                .isEqualTo(31875000);
    }
}
