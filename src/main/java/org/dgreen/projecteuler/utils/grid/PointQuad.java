package org.dgreen.projecteuler.utils.grid;


import java.util.Map;

public record PointQuad(Point a, Point b, Point c, Point d) {
    public int calculateProduct(Map<Point, Integer> grid) {
        return grid.get(a) * grid.get(b) * grid.get(c) * grid.get(d);
    }

    public static final int INDEX_MAX_CHANGE = 3;
}
