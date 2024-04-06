package org.dgreen.projecteuler.utils.grid;


import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;

class PointQuadTest {
    @Test
    void canCalculateTheProductOfFourPointsOnAGrid() {
        var pointOne = new Point(0, 0);
        var pointTwo = new Point(1, 1);
        var pointThree = new Point(2, 2);
        var pointFour = new Point(3, 3);

        var grid = new LinkedHashMap<Point, Integer>();
        grid.put(pointOne, 2);
        grid.put(pointTwo, 3);
        grid.put(pointThree, 4);
        grid.put(pointFour, 5);

        var pointQuad = new PointQuad(pointOne, pointTwo, pointThree, pointFour);

        assertThat(pointQuad.calculateProduct(grid)).isEqualTo(120);
    }
}
