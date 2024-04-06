package org.dgreen.projecteuler;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem15Test {
    @Test
    void canCountRoutesThroughTwoByTwoGridByTraversal() {
        assertThat(Problem15.numberOfRoutesThroughGridByTraversal(2))
                .isEqualTo(6);
    }

    @Test
    void canCountRoutesThroughTwoByTwoGrid() {
        assertThat(Problem15.numberOfRoutesThroughGrid(2))
                .isEqualTo(6);
    }

    @Test
    void canCountRoutesThroughTwentyByTwentyGrid() {
        assertThat(Problem15.numberOfRoutesThroughGrid(20))
                .isEqualTo(137846528820L);
    }
}
