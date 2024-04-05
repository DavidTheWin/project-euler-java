package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemNineTest {
    @Test
    void canCalculateProductOfPythagoreanTripletThatSumsToOneThousand() {
        assertThat(ProblemNine.productOfTriplet())
                .isEqualTo(31875000);
    }
}
